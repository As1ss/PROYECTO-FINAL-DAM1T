/**

La clase OperacionesAdministrador proporciona métodos para realizar operaciones relacionadas con la gestión de libros por parte de un administrador.

Estas operaciones incluyen dar de alta un libro, dar de baja un libro, modificar los detalles de un libro, cargar libros desde un archivo,

guardar libros en un archivo, consultar un libro específico y mostrar todos los libros disponibles.
*/
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
	private String[] opciones = { "Nuevo", "Muy bueno", "Bueno", "Aceptable" };

	/**
	 * 
	 * Crea una instancia de la clase OperacionesAdministrador. Inicializa el
	 * archivo de libros y carga los libros existentes, si hay alguno.
	 */

	public OperacionesAdministrador() {
		file = new File(archivoUsuarios);
		libros = cargarLibros();

	}

	/**
	 * 
	 * Da de alta un nuevo libro con los detalles proporcionados. El libro se agrega
	 * al HashMap de libros y se guarda en el archivo.
	 * 
	 * @param titulo     el título del libro
	 * @param autor      el autor del libro
	 * @param editorial  la editorial del libro
	 * @param ejemplares la cantidad de ejemplares disponibles del libro
	 * @param estado     el estado del libro
	 */

	public void darDeAltaLibro(String titulo, String autor, String editorial, int ejemplares, String estado) {
		Libro libro = new Libro(titulo, autor, editorial, ejemplares, estado);
		libros.put(libro.getId(), libro);
		guardarLibros(); // Actualizar el archivo de libros
	}

	/**
	 * 
	 * Da de baja un libro con el ID especificado. El libro se elimina del HashMap
	 * de libros y se guarda en el archivo.
	 * 
	 * @param id el ID del libro a dar de baja
	 */

	public void darDeBajaLibro(int id) {
		libros.remove(id);
		guardarLibros(); // Actualizar el archivo de libros
	}

	/**
	 * 
	 * Modifica los detalles de un libro con el ID especificado. Si el libro existe
	 * en el HashMap de libros, se actualizan sus atributos con los nuevos valores
	 * proporcionados. Luego, se guarda el libro modificado en el archivo.
	 * 
	 * @param id               el ID del libro a modificar
	 * @param nuevoTitulo      el nuevo título del libro
	 * @param nuevoAutor       el nuevo autor del libro
	 * @param nuevaEditorial   la nueva editorial del libro
	 * @param nuevosEjemplares la nueva cantidad de ejemplares disponibles del libro
	 * @param nuevoEstado      el nuevo estado del libro
	 */

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
		guardarLibros(); // Actualizar el archivo de libros
	}

	/**
	 * 
	 * Carga los libros desde el archivo de libros.
	 * 
	 * Si el archivo existe, se lee el HashMap de libros y se devuelve.
	 * 
	 * Si el archivo no existe, se muestra un mensaje y se devuelve un HashMap
	 * vacío.
	 * 
	 * @return el HashMap de libros cargado desde el archivo o un HashMap vacío si
	 *         ocurre algún error
	 */

	public HashMap<Integer, Libro> cargarLibros() {
		try {
			if (file.exists()) {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

				// Leer el HashMap del archivo
				HashMap<Integer, Libro> hashMap = (HashMap<Integer, Libro>) objectInputStream.readObject();
				objectInputStream.close();

				libros = hashMap; // Asignar el HashMap cargado a la variable libros
				System.out.println("Libros leídos con éxito");

				return hashMap;
			} else {
				System.out.println("El archivo de libros no existe. Se creará uno nuevo.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo de libros no existe. Se creará uno nuevo.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new HashMap<>(); // Si ocurre algún error, se devuelve un HashMap vacío
	}

	/**
	 * 
	 * Guarda los libros en el archivo de libros.
	 * 
	 * Se escribe el HashMap de libros en el archivo para persistir los cambios.
	 */

	public void guardarLibros() {

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

	/**
	 * 
	 * Obtiene el HashMap de libros actual.
	 * 
	 * @return el HashMap de libros actual
	 */

	public HashMap<Integer, Libro> getListaLibros() {
		return libros;
	}

	/**
	 * 
	 * Consulta un libro con el ID especificado.
	 * 
	 * @param id el ID del libro a consultar
	 * @return el libro correspondiente al ID especificado o null si no se encuentra
	 *         ningún libro con ese ID
	 */

	public Libro consultarLibro(int id) {
		return libros.get(id);
	}

	/**
	 * 
	 * Muestra los detalles de todos los libros disponibles. Imprime en la consola
	 * el ID, título, autor, editorial, cantidad de ejemplares y estado de cada
	 * libro.
	 */

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

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

}
