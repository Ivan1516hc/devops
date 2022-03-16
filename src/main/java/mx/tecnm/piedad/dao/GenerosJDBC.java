package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Generos;

@Repository
public class GenerosJDBC {
	//Atributos privados Metodos publicos
		@Autowired
		private JdbcTemplate conexion;

		public List<Generos> consultar() {
			String sql="SELECT * FROM generos WHERE activo=1";
			return conexion.query(sql, new GenerosRM());
		}

		public Generos buscar(int id) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM generos WHERE id=? && activo=1";
			return conexion.queryForObject(sql,new GenerosRM(), id);
		}

		public int insertar(Generos nuevo_genero) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO generos(nombre,descrpcion)"
					+ " VALUES (?,?)";
			conexion.update(sql,nuevo_genero.getNombre(),nuevo_genero.getDescripcion());
			sql="SELECT LAST_INSERT_ID()";
			return conexion.queryForObject(sql, Integer.class);
		}
		
		public void modificar(int id,Generos generos) {
			// TODO Auto-generated method stub
			String sql="UPDATE generos SET nombre=?,descrpcion=?,activo=?, modificado=now() WHERE id=?";
			conexion.update(sql,generos.getNombre(),generos.getDescripcion(),generos.getActivo(),id);
		}
		
		public void desactivar (int id) {
			// TODO Auto-generated method stub
			String sql="UPDATE generos SET activo=0, eliminado=now() WHERE id=?";
			conexion.update(sql,id);
		}

}
