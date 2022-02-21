package mx.tecnm.piedad.models;

import java.math.BigDecimal;

public class Plan {
	//Creacion de todas los campos de nuestra tabla
	//el tipo de variable puede variar depende el tipo de dato que le
	//designamos en la bd
	private int id;
	private String descripcion;
	private BigDecimal precio_mensual;
	private String calidad_video;
	private String resolucion;
	private int cantidad_dispositivos;
	
	//Generacion de Get y Sed de todas las variables
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio_mensual() {
		return precio_mensual;
	}
	public void setPrecio_mensual(BigDecimal precio_mensual) {
		this.precio_mensual = precio_mensual;
	}
	public String getCalidad_video() {
		return calidad_video;
	}
	public void setCalidad_video(String calidad_video) {
		this.calidad_video = calidad_video;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public int getCantidad_dispositivos() {
		return cantidad_dispositivos;
	}
	public void setCantidad_dispositivos(int cantidad_dispositivos) {
		this.cantidad_dispositivos = cantidad_dispositivos;
	}
	
	
	
}
