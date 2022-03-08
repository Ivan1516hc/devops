package mx.tecnm.piedad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CategoriasJDBC;
import mx.tecnm.piedad.models.Categorias;


	@RestController
	@RequestMapping("/api/categorias")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
	
	public class CategoriasWS {
		@Autowired
		CategoriasJDBC repo;
		
		@GetMapping
		public ResponseEntity<?> consultar() {
			List<Categorias> resultado=repo.consultar();
			return new ResponseEntity<List<Categorias>>(resultado, HttpStatus.OK);
		}
		
		@GetMapping("/{categoria-id}")
		public ResponseEntity<?> buscar(@PathVariable ("categoria-id")int id){
			try {
				Categorias resultado= repo.buscar(id);
				return new ResponseEntity<Categorias>(resultado, HttpStatus.OK);
			} 
			catch (DataAccessException e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		}
		
		@PostMapping
		public ResponseEntity<?> insertar(@RequestBody Categorias categoria_nue){
			try {
				repo.insertar(categoria_nue);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		
		@PutMapping("/{categoria-id}")
		public ResponseEntity<?> modificar (@PathVariable ("categoria-id")int id, @RequestBody Categorias categoria_nueva){
			repo.modificar(id, categoria_nueva);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		@DeleteMapping("/{categoria-id}")
		public ResponseEntity<?> desactivar ( @PathVariable ("categoria-id")int id){
			repo.desactivar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
