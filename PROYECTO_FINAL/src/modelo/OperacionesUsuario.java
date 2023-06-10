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

	public OperacionesUsuario() {
		file = new File(archivoUsuarios);
		guardarUsuarios();

	}

	public HashMap<String, Usuario> cargarUsuarios() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Leer el HashMap del archivo
			HashMap<String, Usuario> hashMap = (HashMap<String, Usuario>) objectInputStream.readObject();

			objectInputStream.close();
			System.out.println("HashMap leído del archivo: " + hashMap);
			Usuario usu = hashMap.get("Admin");
			System.out.println(usu.getAlias());
			System.out.println(usu.getContraseña());

			return hashMap;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo de usuarios no existe. Se creará uno nuevo.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios; // Si ocurre algún error, se devuelve un HashMap vacío
	}

	public void guardarUsuarios() {
		usuarios = new HashMap<String, Usuario>();
		agregarUsuario("Admin", "1234", "", "");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(usuarios);

			objectOutputStream.close();
			System.out.println("El HashMap se agregó correctamente al archivo.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void agregarUsuario(String alias, String contraseña, String nombre, String direccion) {
		Usuario usuario = new Usuario(alias, contraseña, nombre, direccion);
		usuarios.put(usuario.getAlias(), usuario);
	}

	public HashMap<String, Usuario> getListaUsuarios() {
		return usuarios;
	}

	public Usuario consultarLibro(String alias) {
		return usuarios.get(alias);
	}

	public Usuario consultarUsuario(String alias) {
		Usuario usuario = usuarios.get(alias);
		return usuario;
	}

	public void eliminarUsuario(String alias) {
		usuarios.remove(alias);
	}

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
