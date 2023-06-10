package modelo;

import java.util.HashMap;

import java.util.HashMap;

public class OperacionesAdministrador {
	private HashMap<Integer, Libro> libros;

	public OperacionesAdministrador() {
		libros = new HashMap<>();
	}

	public void darDeAltaLibro(String titulo, String autor, String editorial, int ejemplares, String estado) {
		Libro libro = new Libro(titulo, autor, editorial, ejemplares, estado);
		libros.put(libro.getId(), libro);
	}

	public void darDeBajaLibro(int id) {
		libros.remove(id);
	}

	public void modificarLibro(int id, String nuevoTitulo, String nuevoAutor, String nuevaEditorial,
			int nuevosEjemplares, String nuevoEstado) {
		if (libros.containsKey(id)) {
			Libro libro = libros.get(id);
			libro.setTitulo(nuevoTitulo);
			libro.setAutor(nuevoAutor);
			libro.setEditorial(nuevaEditorial);
			libro.setEjemplares(nuevosEjemplares);
			libro.setEstado(nuevoEstado);
		}
	}

	public HashMap<Integer, Libro> getListaLibros() {
		return libros;
	}

	public Libro consultarLibro(int id) {
		return libros.get(id);
	}

	public void mostrarLibros() {

		for (Libro libro : libros.values()) {
			if (libro != null) {
				System.out.println("ID:" + libro.getId());
				System.out.println("Titulo: " + libro.getTitulo());
				System.out.println("Autor: " + libro.getAutor());
				System.out.println("Editorial: " + libro.getEditorial());
				System.out.println("Número de ejemplares :" + libro.getEjemplares());
				System.out.println("Estado del libro: " + libro.getEstado());
			}

		}
	}

	public void setLibros(HashMap<Integer, Libro> libros) {
		this.libros = libros;
	}

}
