package modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String alias;
	private String contraseña;
	private String nombre;
	private String direccion;
	private boolean disponibilidadPrestamo;
	private Libro libroPrestado;


	public Usuario(String alias, String contraseña, String nombre, String direccion) {
		
		this.alias = alias;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.direccion = direccion;
		disponibilidadPrestamo = true;

	}

	public void agregarLibroPrestado(Libro libro) {
		this.libroPrestado = libro;
		disponibilidadPrestamo = false;
		
	}

	public void eliminarLibroPrestado() {
		libroPrestado = null;
		disponibilidadPrestamo = true;
	}

	public boolean getDisponibilidadPrestamo() {
		return disponibilidadPrestamo;
	}

	public void setDisponibilidadPrestamo(boolean disponibilidadPrestamo) {
		this.disponibilidadPrestamo = disponibilidadPrestamo;
	}

	// Getters y setters
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Libro getLibroPrestado() {
		return libroPrestado;
	}

	public void setLibroPrestado(Libro libroPrestado) {
		this.libroPrestado = libroPrestado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
