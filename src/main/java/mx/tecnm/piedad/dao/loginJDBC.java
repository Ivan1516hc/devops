package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.tecnm.piedad.models.Cuenta;

public class loginJDBC {

	@Autowired
	private JdbcTemplate conexion;
	
	public Cuenta verificar (Cuenta login_cuenta) {
		// TODO Auto-generated method stub
					String sql="SELECT * FROM cuentas WHERE email= ? AND password= ?";
					return conexion.queryForObject(sql, new CuentaRM(), login_cuenta.getEmail(),login_cuenta.getPassword());
	}
}
