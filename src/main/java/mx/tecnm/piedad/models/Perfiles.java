package mx.tecnm.piedad.models;

public class Perfiles {
	private int id;
	private String nombre;
	private int idioma_id;
	private int clasificacion_edad_id;
	private int cuentas_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdioma_id() {
		return idioma_id;
	}
	public void setIdioma_id(int idioma_id) {
		this.idioma_id = idioma_id;
	}
	public int getClasificacion_edad_id() {
		return clasificacion_edad_id;
	}
	public void setClasificacion_edad_id(int clasificacion_edad_id) {
		this.clasificacion_edad_id = clasificacion_edad_id;
	}
	public int getCuentas_id() {
		return cuentas_id;
	}
	public void setCuentas_id(int cuentas_id) {
		this.cuentas_id = cuentas_id;
	}
	
	
}
