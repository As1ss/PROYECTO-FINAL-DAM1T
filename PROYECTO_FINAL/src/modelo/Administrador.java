package modelo;

public class Administrador {
	private String alias;
	private String contraseña;
	private String rol;

	public Administrador() {
		alias = "Admin";
		contraseña = "1234";
	}

	public void mostrarInformacion() {
		System.out.println("Alias: " + alias);
		System.out.println("Contraseña: " + contraseña);
		System.out.println("Rol: " + rol);
	}

	// Getter y setter específico de Administrador
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

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

}
