package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Perfiles;

@Repository
public class PerfilesJDBC {
	
	//Atributos privados Metodos publicos
		@Autowired
		private JdbcTemplate conexion;
		
		
		
		
		public void modificar(int id,Perfiles perfil) {
			// TODO Auto-generated method stub
			String sql="UPDATE perfiles_usuarios SET nombre=?, idioma_id=?, clasificacion_edad_id=? WHERE id=?";
			conexion.update(sql,perfil.getNombre(),perfil.getIdioma_id(),perfil.getClasificacion_edad_id(), id);
		}
		public void eliminar(int id) {
			// TODO Auto-generated method stub
			String sql="UPDATE perfiles_usuarios SET activo=0 WHERE id=?";
			conexion.update(sql, id);
		}
}
