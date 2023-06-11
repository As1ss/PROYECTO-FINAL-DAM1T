package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import java.util.HashMap;

public class OperacionesAdministrador {
	private HashMap<Integer, Libro> libros;
	private String archivoUsuarios = "src/documentos/libros.data";
	private File file;

	public OperacionesAdministrador() {
		file = new File(archivoUsuarios);
		libros = new HashMap<Integer, Libro>();
		guardarLibros();
		cargarLibros();
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

	public HashMap<Integer, Libro> cargarLibros() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Leer el HashMap del archivo
			HashMap<Integer, Libro> hashMap = (HashMap<Integer, Libro>) objectInputStream.readObject();
			objectInputStream.close();
			System.out.println("Libros leidos con exitos");
			System.out.println("Libros leidos");
			for (HashMap.Entry<Integer, Libro> entry : hashMap.entrySet()) {
				Integer key = entry.getKey();
				Libro libro = entry.getValue();
				System.out.println("Clave: " + key + ", Libro: " + libro+" Nombre: "+libro.getTitulo());
			}
			Libro libro = hashMap.get(hashMap);
			return hashMap;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo de libros no existe. Se creará uno nuevo.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return libros; // Si ocurre algún error, se devuelve un HashMap vacío
	}

	public void guardarLibros() {
		darDeAltaLibro("Libro1", "", "", 0, "");
		darDeAltaLibro("Libro2", "", "", 0, "");
		darDeAltaLibro("Libro3", "", "", 0, "");
		darDeAltaLibro("Libro4", "", "", 0, "");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(libros);
			System.out.println("Guardado con exito");
			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
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
