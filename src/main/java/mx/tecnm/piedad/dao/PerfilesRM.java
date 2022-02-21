package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Perfiles;

public class PerfilesRM implements RowMapper<Perfiles> {

	@Override
	public Perfiles mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Perfiles perfiles=new Perfiles();
		perfiles.setId(rs.getInt("id"));
		perfiles.setNombre(rs.getString("nombre"));
		perfiles.setIdioma_id(rs.getInt("idioma_id"));
		perfiles.setClasificacion_edad_id(rs.getInt("clasificacion_edad_id"));
		perfiles.setCuentas_id(rs.getInt("cuentas_id"));
		return perfiles;
	}
	
}
