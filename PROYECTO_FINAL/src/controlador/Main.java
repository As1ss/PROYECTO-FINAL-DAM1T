package controlador;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import modelo.OperacionesUsuario;

public class Main {

	public static void main(String[] args) {
		try {
			//Esto proporciona un aspecto mas atractivo de la interfaz
			UIManager.setLookAndFeel(new NimbusLookAndFeel());

			new ControladorVentanaPrincipal();
		} catch (Exception e) {

		}

	}

}
