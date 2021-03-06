package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Actores;

@Repository
public class ActorJDBC {
	
	//Atributos privados Metodos publicos
	@Autowired
	private JdbcTemplate conexion;

	public List<Actores> consultar() {
		String sql="SELECT * FROM actores WHERE activo=1";
		return conexion.query(sql, new ActorRM());
	}

	public Actores buscar(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM actores WHERE id=? && activo=1";
		return conexion.queryForObject(sql,new ActorRM(), id);
	}

	public int insertar(Actores nuevo_actor) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO actores(nombre)"
				+ " VALUES (?)";
		conexion.update(sql,nuevo_actor.getNombre_completo());
		sql="SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
	
	public void modificar(int id,Actores actor) {
		// TODO Auto-generated method stub
		String sql="UPDATE actores SET nombre=?,activo=?, modificado=now() WHERE id=?";
		conexion.update(sql,actor.getNombre_completo(),actor.getActivo(),id);
	}
	
	public void desactivar (int id) {
		// TODO Auto-generated method stub
		String sql="UPDATE actores SET activo=0, eliminado=now() WHERE id=?";
		conexion.update(sql,id);
	}
}
