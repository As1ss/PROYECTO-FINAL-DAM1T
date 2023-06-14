/**

OperacionesUsuario es una clase que se encarga de realizar las operaciones relacionadas con los usuarios en el sistema de gestión de libros.

Permite agregar, consultar, eliminar y mostrar información de los usuarios, así como cargar y guardar los datos de usuarios en un archivo.

Esta clase utiliza un HashMap para almacenar los usuarios, donde la clave es el alias del usuario y el valor es una instancia de la clase Usuario.

@see Usuario
*/
package modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class OperacionesUsuario {
	private HashMap<String, Usuario> usuarios;
	private String archivoUsuarios = "src/documentos/usuarios.data";
	private File file;

	/**
	 * 
	 * Constructor de la clase OperacionesUsuario.
	 * 
	 * Carga los usuarios existentes desde el archivo y verifica si el usuario
	 * "Admin" ya existe. Si no existe, se agrega automáticamente.
	 */

	public OperacionesUsuario() {

		file = new File(archivoUsuarios);
		usuarios = cargarUsuarios();

		// Verificar si el usuario "Admin" ya existe
		if (!usuarios.containsKey("Admin")) {
			agregarUsuario("Admin", "1234", "", "");
		}
	}

	/**
	 * 
	 * Carga los usuarios desde el archivo de usuarios.
	 * 
	 * Si el archivo existe, se lee el HashMap almacenado en el archivo y se
	 * devuelve.
	 * 
	 * Si el archivo no existe, se crea uno nuevo y se devuelve un HashMap vacío.
	 * 
	 * Si ocurre algún error durante la carga, se devuelve un HashMap vacío.
	 * 
	 * @return un HashMap que contiene los usuarios cargados desde el archivo o un
	 *         HashMap vacío si ocurre algún error
	 */

	public HashMap<String, Usuario> cargarUsuarios() {
		try {
			if (file.exists()) {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

				// Leer el HashMap del archivo
				HashMap<String, Usuario> hashMap = (HashMap<String, Usuario>) objectInputStream.readObject();
				objectInputStream.close();

				return hashMap;
			} else {
				System.out.println("El archivo de usuarios no existe. Se creará uno nuevo.");
				return new HashMap<>();
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo de usuarios no existe. Se creará uno nuevo.");
		} catch (EOFException e) {
			// El archivo está vacío, se devuelve un HashMap vacío
			return new HashMap<>();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new HashMap<>(); // Si ocurre algún error, se devuelve un HashMap vacío
	}

	/**
	 * 
	 * Guarda los usuarios en el archivo de usuarios.
	 * 
	 * Actualiza el estado de disponibilidadPrestamo y libroPrestado de cada usuario
	 * antes de guardarlos.
	 * 
	 * @see Usuario#setDisponibilidadPrestamo(boolean)
	 * 
	 * @see Usuario#getLibroPrestado()
	 */

	public void guardarUsuarios() {

		// Asignar el estado actualizado de disponibilidadPrestamo y libroPrestado a
		// cada usuario
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getLibroPrestado() != null) {
				usuario.setDisponibilidadPrestamo(false);
			} else {
				usuario.setDisponibilidadPrestamo(true);
			}
		}

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(usuarios);
			objectOutputStream.close();
			System.out.println("Usuarios guardados exitosamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Agrega un nuevo usuario al sistema.
	 * 
	 * @param alias      el alias del usuario
	 * @param contraseña la contraseña del usuario
	 * @param nombre     el nombre del usuario
	 * @param direccion  la dirección del usuario
	 */

	public void agregarUsuario(String alias, String contraseña, String nombre, String direccion) {
		Usuario usuario = new Usuario(alias, contraseña, nombre, direccion);
		usuarios.put(usuario.getAlias(), usuario);

	}

	/**
	 * 
	 * Devuelve el HashMap de usuarios.
	 * 
	 * @return el HashMap de usuarios
	 */

	public HashMap<String, Usuario> getListaUsuarios() {
		return usuarios;
	}

	public Usuario consultarLibro(String alias) {
		return usuarios.get(alias);
	}

	/**
	 * 
	 * Consulta un usuario por su alias.
	 * 
	 * @param alias el alias del usuario a consultar
	 * @return el usuario correspondiente al alias especificado, o null si no se
	 *         encuentra
	 */

	public Usuario consultarUsuario(String alias) {
		Usuario usuario = usuarios.get(alias);
		return usuario;
	}

	/**
	 * 
	 * Elimina un usuario del sistema.
	 * 
	 * @param alias el alias del usuario a eliminar
	 */

	public void eliminarUsuario(String alias) {
		usuarios.remove(alias);
	}

	/**
	 * 
	 * Muestra la información de todos los usuarios en el sistema.
	 */

	public void mostrarUsuarios() {
		for (Usuario usuario : usuarios.values()) {
			if (usuario != null) {
				System.out.println("Alias: " + usuario.getAlias());
				System.out.println("Contraseña: " + usuario.getContraseña());
				System.out.println("Nombre: " + usuario.getNombre());
				System.out.println("Dirección: " + usuario.getDireccion());
				System.out.println("Disponibilidad de préstamo: " + usuario.getDisponibilidadPrestamo());

			}

		}
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
