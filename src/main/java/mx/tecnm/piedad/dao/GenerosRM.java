package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Generos;

public class GenerosRM implements RowMapper<Generos>{

	@Override
	public Generos mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Generos generos=new Generos();
		generos.setId(rs.getInt("id"));
		generos.setNombre(rs.getString("nombre"));
		generos.setDescripcion(rs.getString("descrpcion"));
		generos.setActivo(rs.getInt("activo"));
		return generos;
	}
}
