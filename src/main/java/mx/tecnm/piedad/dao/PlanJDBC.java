package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Cuenta;
import mx.tecnm.piedad.models.Plan;

@Repository
public class PlanJDBC {
	
	//Atributos privados Metodos publicos
	@Autowired
	private JdbcTemplate conexion;
	
	public List<Plan> consultar() {
		String sql="SELECT * FROM planes WHERE activo=1";
		return conexion.query(sql, new PlanRM());
	}

	public Plan buscar(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM planes WHERE id=? AND activo=1";
		return conexion.queryForObject(sql,new PlanRM(), id);
	}
	public void modificarPlan(int idP,int idC) {
		// TODO Auto-generated method stub
		String sql="UPDATE cuentas SET planes_id=? WHERE id=?";
		conexion.update(sql,idP,idC);
	}
	public int insertar(Cuenta nueva_cuenta, int id) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO cuentas(email,password,nombre,apellido,numero_tarjeta,fecha_vencimiento,codigo_seguridad,tipo_tarjeta_id,planes_id)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		conexion.update(sql,nueva_cuenta.getEmail(),nueva_cuenta.getPassword(),nueva_cuenta.getNombre(),nueva_cuenta.getApellido(),nueva_cuenta.getNumero_tarjeta(), 
				nueva_cuenta.getFecha_vencimiento(),nueva_cuenta.getCodigo_seguridad(),nueva_cuenta.getTipo_tarjeta_id(),id);
		sql="SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
}
