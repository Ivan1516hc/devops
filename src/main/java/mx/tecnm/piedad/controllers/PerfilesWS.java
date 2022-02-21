package mx.tecnm.piedad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.PerfilesJDBC;
import mx.tecnm.piedad.models.Perfiles;

@RestController
@RequestMapping("/api")
public class PerfilesWS {
	@Autowired
	PerfilesJDBC repo;
	

	@PutMapping("/perfiles/{perfil-id}")
	public ResponseEntity<?> modificar (@PathVariable ("perfiles-id")int id, @RequestBody Perfiles perfil){
		repo.modificar(id, perfil);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping("/perfiles/{perfil-id}")
	public ResponseEntity<?> eliminar ( @PathVariable ("perfil-id")int id){
		repo.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
