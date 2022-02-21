package mx.tecnm.piedad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.tecnm.piedad.dao.PlanJDBC;
import mx.tecnm.piedad.models.Cuenta;
import mx.tecnm.piedad.models.Plan;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class PlanWS {
	@Autowired
	PlanJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> consultar() {
		List<Plan> resultado=repo.consultar();
		return new ResponseEntity<List<Plan>>(resultado, HttpStatus.OK);
	}
	@GetMapping("/{plan-id}")
	public ResponseEntity<?> buscar(@PathVariable ("plan-id")int id){
		try {
			Plan resultado= repo.buscar(id);
			return new ResponseEntity<Plan>(resultado, HttpStatus.OK);
		} 
		catch (DataAccessException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	@PostMapping("/{plan-id}/cuenta")
	public ResponseEntity<?> insertar(@PathVariable ("plan-id")int id,@RequestBody Cuenta nueva_cuenta){
		try {
			repo.insertar(nueva_cuenta,id);
			return new ResponseEntity<>(id,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	@PutMapping("/{plan-id}/cuentas/{cuenta-id}")
	public ResponseEntity<?> modificarPlan (@PathVariable ("plan-id")int idP, @PathVariable ("cuenta-id")int idC){
		repo.modificarPlan(idP,idC);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
