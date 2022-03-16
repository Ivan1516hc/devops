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

import mx.tecnm.piedad.dao.GenerosJDBC;
import mx.tecnm.piedad.models.Generos;

@RestController
@RequestMapping("/api/generos")
public class GenerosWS {
	@Autowired
	GenerosJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Generos> resultado=repo.consultar();
		return new ResponseEntity<List<Generos>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/{genero-id}")
	public ResponseEntity<?> buscar(@PathVariable ("genero-id")int id){
		try {
			Generos resultado= repo.buscar(id);
			return new ResponseEntity<Generos>(resultado, HttpStatus.OK);
		} 
		catch (DataAccessException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody Generos nuevo_genero){
		try {
			repo.insertar(nuevo_genero);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	@PutMapping("/{genero-id}")
	public ResponseEntity<?> modificar (@PathVariable ("genero-id")int id, @RequestBody Generos generos){
		repo.modificar(id, generos);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping("/{genero-id}")
	public ResponseEntity<?> desactivar ( @PathVariable ("genero-id")int id){
		repo.desactivar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
