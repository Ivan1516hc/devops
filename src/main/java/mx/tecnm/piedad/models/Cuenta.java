package mx.tecnm.piedad.models;

public class Cuenta {
	private int id;
	private String email;
	private String password;
	private int activa;
	private String fecha_ultimo_pago;
	private String nombre;
	private String apellido;
	private String numero_tarjeta;
	private String fecha_vencimiento;
	private String codigo_seguridad;
	private int tipo_tarjeta_id;
	private int planes_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActiva() {
		return activa;
	}
	public void setActiva(int activa) {
		this.activa = activa;
	}
	public String getFecha_ultimo_pago() {
		return fecha_ultimo_pago;
	}
	public void setFecha_ultimo_pago(String fecha_ultimo_pago) {
		this.fecha_ultimo_pago = fecha_ultimo_pago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}
	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public String getCodigo_seguridad() {
		return codigo_seguridad;
	}
	public void setCodigo_seguridad(String codigo_seguridad) {
		this.codigo_seguridad = codigo_seguridad;
	}
	public int getTipo_tarjeta_id() {
		return tipo_tarjeta_id;
	}
	public void setTipo_tarjeta_id(int tipo_tarjeta_id) {
		this.tipo_tarjeta_id = tipo_tarjeta_id;
	}
	public int getPlanes_id() {
		return planes_id;
	}
	public void setPlanes_id(int planes_id) {
		this.planes_id = planes_id;
	}

	
}
