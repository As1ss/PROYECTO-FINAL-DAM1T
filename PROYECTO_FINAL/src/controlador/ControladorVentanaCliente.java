package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import modelo.Libro;
import modelo.OperacionesAdministrador;
import modelo.OperacionesCliente;
import modelo.Usuario;
import vista.VentanaCliente;

public class ControladorVentanaCliente implements ActionListener {

	VentanaCliente ventanaCli;
	OperacionesCliente operacionesCli;
	OperacionesAdministrador operacionesAdmin;
	private HashMap<Integer, Libro> libros;
	private int indiceActual;
	private Usuario usu;

	public ControladorVentanaCliente(Usuario usu) {

		this.usu = usu;
		
		operacionesAdmin = new OperacionesAdministrador();
		operacionesCli = new OperacionesCliente(operacionesAdmin);
		ventanaCli = new VentanaCliente();
		ventanaCli.setTitle("cliente");
		ventanaCli.getBtnDevolucion().addActionListener(this);
		ventanaCli.getBtnDevolver().addActionListener(this);
		ventanaCli.getBtnPedido().addActionListener(this);
		ventanaCli.getBtnPedir().addActionListener(this);
	
		ventanaCli.setVisible(true);
		libros = operacionesAdmin.cargarLibros();
		indiceActual = 0;
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventanaCli.getBtnDevolucion()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelDevolucion");

		}

		if (e.getSource() == ventanaCli.getBtnPedido()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelPedido");

		}

		
		
		if (e.getSource() == ventanaCli.getBtnPedir()) {
			
			operacionesCli.cogerLibro(indiceActual, usu);
			
		}
		
		if (e.getSource() == ventanaCli.getBtnDevolver()) {
			
			operacionesCli.devolverLibro(indiceActual, usu);
			
		}

	}



}
