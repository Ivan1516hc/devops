package mx.tecnm.piedad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CuentaJDBC;
import mx.tecnm.piedad.models.Cuenta;
import mx.tecnm.piedad.models.Perfiles;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaWS {
	@Autowired
	CuentaJDBC repo;
	
	
	
	@PutMapping("/{cuenta-id}")
	public ResponseEntity<?> modificar (@PathVariable ("cuenta-id")int id, @RequestBody Cuenta cuenta){
		repo.modificar(id, cuenta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{cuenta-id}/perfiles")
	public ResponseEntity<?> consultar(@PathVariable ("cuenta-id")int id){
		try {
			List<Perfiles> resultado=repo.consultar(id);
			return new ResponseEntity<List<Perfiles>>(resultado, HttpStatus.OK);
		} 
		catch (DataAccessException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@DeleteMapping("/{cuenta-id}")
	public ResponseEntity<?> desactivar ( @PathVariable ("cuenta-id")int id){
		repo.desactivar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/{cuenta-id}/perfiles")
	public ResponseEntity<?> insertar(@PathVariable ("cuenta-id")int id,@RequestBody Perfiles nuevo_perfil){
		try {
			repo.insertarP(nuevo_perfil,id);
			return new ResponseEntity<>(id,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
