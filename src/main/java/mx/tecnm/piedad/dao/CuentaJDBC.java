package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Cuenta;
import mx.tecnm.piedad.models.Perfiles;


@Repository
public class CuentaJDBC {
	//Atributos privados Metodos publicos
		@Autowired
		private JdbcTemplate conexion;

		public void desactivar(int id) {
			// TODO Auto-generated method stub
			String sql="UPDATE cuentas SET activa=0 WHERE id=?";
			conexion.update(sql, id);
		}

		public void modificar(int id,Cuenta cuenta) {
			// TODO Auto-generated method stub
			String sql="UPDATE cuentas SET email=?, password=?, nombre=?, apellido=?, numero_tarjeta=?, fecha_vencimiento=?, codigo_seguridad=?, "
					+ " tipo_tarjeta_id=? WHERE id=?";
			conexion.update(sql,cuenta.getEmail(), cuenta.getPassword(), cuenta.getNombre(),cuenta.getApellido(),cuenta.getNumero_tarjeta(),
					cuenta.getFecha_vencimiento(),cuenta.getCodigo_seguridad(),cuenta.getTipo_tarjeta_id(), id);
			
		}

		
		
		
		public List<Perfiles> consultar(int id) {
			String sql="SELECT * FROM perfiles_usuarios u JOIN cuentas c ON c.id=u.cuentas_id WHERE c.activa=1 AND u.activo=1 AND u.cuentas_id=?";
			return conexion.query(sql, new PerfilesRM(), id);
		}
		public Cuenta verificar (Cuenta login_cuenta) {
			// TODO Auto-generated method stub
						String sql="SELECT * FROM cuentas WHERE email= ? AND password= ?";
						return conexion.queryForObject(sql, new CuentaRM(), login_cuenta.getEmail(),login_cuenta.getPassword());
		}
		public int insertarP(Perfiles nuevo_perfil, int id) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO perfiles_usuarios (nombre,idioma_id,clasificacion_edad_id,cuentas_id) VALUES (?,?,?,?)";
			conexion.update(sql,nuevo_perfil.getNombre(),nuevo_perfil.getIdioma_id(),nuevo_perfil.getClasificacion_edad_id(),id);
			sql="SELECT LAST_INSERT_ID()";
			return conexion.queryForObject(sql, Integer.class);
		}
		
		/*public void verificar (String cuenta,String password) {
			// TODO Auto-generated method stub
						String sql="SELECT * FROM cuentas WHERE email=? AND password=?";
						conexion.update(sql,cuenta,password);
		}*/
}
