package mx.tecnm.piedad.controllers;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.tecnm.piedad.dao.UsuariosJDBC;

@RestController
@RequestMapping("/api")
public class LoginWS {
	@Autowired
	UsuariosJDBC repo;

	@PostMapping("/login")
	public ResponseEntity<?> autenticar(@RequestParam String email, @RequestParam String contrasena){
			String  token="";
			if (repo.login(email, contrasena)) {
				token = getJWTToken(email);
				return new ResponseEntity<String>(token,HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
	}
	private String getJWTToken(String username) {
		String secretKey = "abracadabra";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
