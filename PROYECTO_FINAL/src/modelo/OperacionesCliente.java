
/**

OperacionesCliente es una clase que se encarga de realizar las operaciones relacionadas con los clientes en el sistema de gestión de libros.

Permite a los clientes tomar prestados libros disponibles y devolver libros prestados.

Esta clase se comunica con las clases OperacionesAdministrador, OperacionesUsuario y Libro.

@see OperacionesAdministrador

@see OperacionesUsuario

@see Libro
*/
package modelo;

import java.util.HashMap;

public class OperacionesCliente {
	private OperacionesAdministrador operaciones;
	private OperacionesUsuario operacionesUsu;

	/**
	 * 
	 * Constructor de la clase OperacionesCliente.
	 * 
	 * @param operaciones    la instancia de la clase OperacionesAdministrador para
	 *                       realizar operaciones relacionadas con los libros
	 * @param operacionesUsu la instancia de la clase OperacionesUsuario para
	 *                       realizar operaciones relacionadas con los usuarios
	 */

	public OperacionesCliente(OperacionesAdministrador operaciones, OperacionesUsuario operacionesUsu) {
		this.operacionesUsu = operacionesUsu;
		this.operaciones = operaciones;

	}

	/**
	 * 
	 * Permite a un cliente tomar prestado un libro. Verifica si el libro está
	 * disponible, el cliente tiene disponibilidad de préstamo y realiza las
	 * operaciones correspondientes. Actualiza la cantidad de ejemplares del libro,
	 * agrega el libro prestado al cliente y guarda los cambios en los archivos
	 * correspondientes.
	 * 
	 * @param idLibro el ID del libro a tomar prestado
	 * @param usuario el cliente que toma prestado el libro
	 */
	public void cogerLibro(int idLibro, Usuario usuario) {
		Libro libro = operaciones.consultarLibro(idLibro);
		if (libro != null && libro.getEjemplares() > 0 && usuario.getDisponibilidadPrestamo()) {
			libro.setEjemplares(libro.getEjemplares() - 1);
			usuario.agregarLibroPrestado(libro);
			System.out.println("El libro ha sido cogido por el cliente.");
			operacionesUsu.guardarUsuarios();
			operaciones.guardarLibros();

		} else {
			System.out.println("El libro no está disponible para préstamo.");
		}
	}

	/**
	 * 
	 * Permite a un cliente devolver un libro prestado. Verifica si el libro está en
	 * posesión del cliente y realiza las operaciones correspondientes. Actualiza la
	 * cantidad de ejemplares del libro, elimina el libro prestado del cliente y
	 * guarda los cambios en los archivos correspondientes.
	 * 
	 * @param idLibro el ID del libro a devolver
	 * @param usuario el cliente que devuelve el libro
	 */
	public void devolverLibro(int idLibro, Usuario usuario) {
		Libro libro = operaciones.consultarLibro(idLibro);
		if (libro != null && usuario.getDisponibilidadPrestamo() == false) {
			libro.setEjemplares(libro.getEjemplares() + 1);
			usuario.eliminarLibroPrestado();
			System.out.println("El libro ha sido devuelto por el cliente.");
			operacionesUsu.guardarUsuarios();
			operaciones.guardarLibros();
		} else {
			System.out.println("El cliente no tiene prestado ese libro.");
		}
	}
}
