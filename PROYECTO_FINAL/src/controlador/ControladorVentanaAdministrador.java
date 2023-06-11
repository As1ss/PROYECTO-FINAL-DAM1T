package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.OperacionesAdministrador;
import vista.VentanaAdministrador;

public class ControladorVentanaAdministrador implements ActionListener{
	OperacionesAdministrador operacionesAdmin;
	VentanaAdministrador ventanaAdmin;

	public ControladorVentanaAdministrador() {
		operacionesAdmin = new OperacionesAdministrador();
		ventanaAdmin = new VentanaAdministrador();
		ventanaAdmin.setTitle("Administracion");
		ventanaAdmin.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
