/**

Usuario es una clase que representa a un usuario cliente del sistema.

Contiene información sobre el alias, contraseña, nombre, dirección, disponibilidad de préstamo y libro prestado del usuario.

Implementa la interfaz Serializable para permitir la serialización de objetos Usuario.
*/
package modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String alias;
	private String contraseña;
	private String nombre;
	private String direccion;
	private boolean disponibilidadPrestamo;
	private Libro libroPrestado;

	/**
	 * 
	 * Constructor de la clase Usuario.
	 * 
	 * @param alias      el alias del usuario
	 * @param contraseña la contraseña del usuario
	 * @param nombre     el nombre del usuario
	 * @param direccion  la dirección del usuario
	 */
	public Usuario(String alias, String contraseña, String nombre, String direccion) {

		this.alias = alias;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.direccion = direccion;
		disponibilidadPrestamo = true;

	}

	/**
	 * 
	 * Agrega un libro prestado al usuario.
	 * 
	 * @param libro el libro prestado
	 */

	public void agregarLibroPrestado(Libro libro) {
		this.libroPrestado = libro;
		disponibilidadPrestamo = false;

	}

	/**
	 * 
	 * Elimina el libro prestado del usuario.
	 */

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
