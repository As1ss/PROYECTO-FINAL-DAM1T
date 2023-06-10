package controlador;

import java.util.Scanner;

import modelo.Administrador;
import modelo.OperacionesAdministrador;
import modelo.OperacionesCliente;
import modelo.OperacionesUsuario;
import modelo.Usuario;

public class Main {

	private static OperacionesAdministrador operacionesAdmin;
	private static OperacionesUsuario operacionesUsu;
	private static OperacionesCliente operacionesCli;
	private static Scanner scanner;

	public static void main(String[] args) {
		operacionesAdmin = new OperacionesAdministrador();
		operacionesUsu = new OperacionesUsuario();
		operacionesCli = new OperacionesCliente(operacionesAdmin);
		Administrador admin = new Administrador();

		scanner = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("1. Menu Usuarios");
			System.out.println("2. Menu Libros");
			System.out.println("3. Menu Préstamos");
			System.out.println("4. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion) {

			case 1:
				menuUsuario();
				break;
			case 2:
				menuLibros();
				break;
			case 3:
				menuPrestamos();
				break;
			case 4:
				break;
			}

		} while (opcion != 4);

	}

	private static void menuPrestamos() {
		int opcion;
		do {
			System.out.println("1. Coger libro");
			System.out.println("2. Devolver libro");
			System.out.println("3. Salir");
			opcion = scanner.nextInt();
			scanner.nextLine();// Limpiar el buffer de entrada
			switch (opcion) {
			case 1:
				System.out.println("Introduce el ID del libro que desee coger");
				operacionesAdmin.mostrarLibros();
				int idLibro = scanner.nextInt();
				System.out.println("Introduce el Alias");
				String aliasTemp = scanner.next();
				operacionesUsu.mostrarUsuarios();

				Usuario usuTemp = operacionesUsu.consultarUsuario(aliasTemp);

				operacionesCli.cogerLibro(idLibro, usuTemp);
				System.out.println("El cliente: " + usuTemp.getAlias() + " ha cogido el libro "
						+ usuTemp.getLibroPrestado().getTitulo());

				

				break;
			case 2:
				break;
			case 3:
				break;
			}

		} while (opcion != 3);

	}

	private static void menuLibros() {
		int opcion;
		do {
			System.out.println("1. Añadir libro");
			System.out.println("2. Mostrar Libros disponibles");
			System.out.println("3. Eliminar libro");
			System.out.println("4. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer de entrada

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el título del libro: ");
				String titulo = scanner.nextLine();

				System.out.print("Ingrese el autor del libro: ");
				String autor = scanner.nextLine();

				System.out.print("Ingrese la editorial del libro: ");
				String editorial = scanner.nextLine();

				System.out.print("Ingrese el número de ejemplares del libro: ");
				int ejemplares = scanner.nextInt();
				scanner.nextLine(); // Limpiar el buffer de entrada

				System.out.print("Ingrese el estado del libro: ");
				String estado = scanner.nextLine();

				operacionesAdmin.darDeAltaLibro(titulo, autor, editorial, ejemplares, estado);
				System.out.println("Libro añadido correctamente.");
				break;
			case 2:
				operacionesAdmin.mostrarLibros();
				break;
			case 3:
				System.out.println("Ingrese el ID del libro que desea eliminar");
				int numID = scanner.nextInt();
				operacionesAdmin.darDeBajaLibro(numID);
				System.out.println("Se ha eliminado el libro correctamente.");
				break;
			case 4:
				System.out.println("Saliendo del programa...");

				break;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
			}

			System.out.println();
		} while (opcion != 4);
	}

	private static void menuUsuario() {
		String alias;
		int opcion;
		do {
			System.out.println("1. Añadir usuario");
			System.out.println("2. Mostrar Usuarios disponibles");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer de entrada

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el alias del usuario");
				alias = scanner.nextLine();

				System.out.print("Ingrese la contraseña del usuario: ");
				String contraseña = scanner.nextLine();

				System.out.println("Ingresa el nombre del usuario");
				String nombre = scanner.nextLine();
				System.out.println("Ingresa la dirección del usuario");
				String direccion = scanner.nextLine();
				operacionesUsu.agregarUsuario(alias, contraseña, nombre, direccion);

				break;
			case 2:
				operacionesUsu.mostrarUsuarios();
				break;
			case 3:
				System.out.println("Ingrese el alias del usuario que desea eliminar");
				alias = scanner.nextLine();
				operacionesUsu.eliminarUsuario(alias);
				System.out.println("Se ha eliminado el usuario correctamente.");
				break;
			case 4:
				System.out.println("Saliendo del programa...");

				break;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
			}

			System.out.println();
		} while (opcion != 4);
	}
}
