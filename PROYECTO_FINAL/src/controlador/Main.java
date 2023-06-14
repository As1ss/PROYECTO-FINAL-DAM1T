/**
 * La clase Main es la clase de entrada para la aplicación.
 * Configura el aspecto de la interfaz de usuario y crea una instancia de ControladorVentanaPrincipal.
 */
package controlador;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import modelo.OperacionesUsuario;

public class Main {

	/**
	 * El método main es el punto de entrada de la aplicación. Configura el aspecto
	 * de la interfaz de usuario y crea una instancia de
	 * ControladorVentanaPrincipal.
	 *
	 * @param args los argumentos de línea de comandos (no se utilizan en este caso)
	 */
	public static void main(String[] args) {
		try {
			// Esto proporciona un aspecto más atractivo de la interfaz
			UIManager.setLookAndFeel(new NimbusLookAndFeel());

			// Crea una instancia de ControladorVentanaPrincipal
			new ControladorVentanaPrincipal();
		} catch (Exception e) {
			// Manejo de excepciones (en este caso no se realiza ninguna acción)
		}
	}
}