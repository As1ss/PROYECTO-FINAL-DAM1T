package modelo;

import java.util.HashMap;
import java.util.Map;

public class OperacionesUsuario {
	private HashMap<String, Usuario> usuarios;

	public OperacionesUsuario() {
		usuarios = new HashMap<>();
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
