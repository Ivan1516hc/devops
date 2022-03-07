package mx.tecnm.piedad.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriasJDBC {
	
	//Atributos privados Metodos publicos
	@Autowired
	private JdbcTemplate conexion;
	
	public List<Categorias> consultar() {
		String sql="SELECT * FROM categorias";
		return conexion.query(sql, new CategoriasRM());
	}

	public Categorias buscar(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM categorias WHERE id=?";
		return conexion.queryForObject(sql,new CategoriasRM(), id);
	}

	public int insertar(Categorias nueva_categoria) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO categorias(clasificacion,descripcion)"
				+ " VALUES (?,?)";
		conexion.update(sql,nueva_categoria.getClasificacion(),nueva_categoria.getDescripcion());
		sql="SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
	
	public void modificar(int id,Categorias categoria) {
		// TODO Auto-generated method stub
		String sql="UPDATE categorias SET clasificacion=?,descripcion=? WHERE id=?";
		conexion.update(sql,categoria.getClasificacion(),categoria.getDescripcion(),id);
	}	
}
