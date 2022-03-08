package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriasJDBC {
	@Autowired
	private JdbcTemplate conexion;

	public void desactivar(int id) {
		// TODO Auto-generated method stub
		String sql="UPDATE categorias SET activo=0, eliminado=now() WHERE id=?";
		conexion.update(sql, id);
	}

	public void modificar(int id,Categorias categoria_nue) {
		// TODO Auto-generated method stub
		String sql="UPDATE categorias SET clasificacion=?, descripcion=?, activo=?, modificado=now() WHERE id=?";
		conexion.update(sql,categoria_nue.getClasificacion(), categoria_nue.getDescripcion(), categoria_nue.getActivo(),  id);	
	}
	
	public int insertar(Categorias categoria_nueva) {
	// TODO Auto-generated method stub
	String sql="INSERT INTO categorias (clasificacion,descripcion) VALUES (?,?)";
	conexion.update(sql,categoria_nueva.getClasificacion(),categoria_nueva.getDescripcion());
	sql="SELECT LAST_INSERT_ID()";
	return conexion.queryForObject(sql, Integer.class);
	}
	
	public Categorias buscar(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM categorias WHERE id=? AND activo=1";
		return conexion.queryForObject(sql,new CategoriasRM(), id);
	}
	
	public List<Categorias> consultar() {
		String sql="SELECT * FROM categorias WHERE activo=1";
		return conexion.query(sql, new CategoriasRM());
	}
}





