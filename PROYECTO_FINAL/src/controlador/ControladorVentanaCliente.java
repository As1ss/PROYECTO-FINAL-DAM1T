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
		ventanaCli.getBotonAnterior().addActionListener(this);
		ventanaCli.getBotonSiguiente().addActionListener(this);
		ventanaCli.setVisible(true);
		libros = operacionesAdmin.cargarLibros();
		indiceActual = 0;
		mostrarDetalleLibro();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventanaCli.getBtnDevolucion()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelDevolucion");

		}

		if (e.getSource() == ventanaCli.getBtnPedido()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelPedido");

		}

		if (e.getSource() == ventanaCli.getBotonAnterior()) {
			if (indiceActual > 0) {
				indiceActual--;
			} else {
				indiceActual = libros.size() - 1;
			}
			mostrarDetalleLibro();
		}

		if (e.getSource() == ventanaCli.getBotonSiguiente()) {
			if (indiceActual < libros.size() - 1) {
				indiceActual++;
			} else {
				indiceActual = 0;
			}
			mostrarDetalleLibro();
		}
		
		if (e.getSource() == ventanaCli.getBtnPedir()) {
			
			operacionesCli.cogerLibro(indiceActual, usu);
			
		}
		
		if (e.getSource() == ventanaCli.getBtnDevolver()) {
			
			operacionesCli.devolverLibro(indiceActual, usu);
			
		}

	}

	private void mostrarDetalleLibro() {
		Libro libroActual = libros.get(indiceActual);
		ventanaCli.getImagenLibroPedir().setIcon(libroActual.getImg());
		ventanaCli.getLabelTituloPedir().setText("Título: " + libroActual.getTitulo());
		ventanaCli.getLabelEditorialPedir().setText("Editorial: " + libroActual.getEditorial());
		ventanaCli.getLabelAutorPedir().setText("Autor: " + libroActual.getAutor());
		ventanaCli.getLabelEjemplaresPedir().setText("Ejemplares: " + libroActual.getEjemplares());
		ventanaCli.getLabelEstadoPedir().setText("Estado: " + libroActual.getEstado());

		ventanaCli.getImagenLibroDevolver().setIcon(libroActual.getImg());
		ventanaCli.getLabelTituloDevolver().setText("Título: " + libroActual.getTitulo());
		ventanaCli.getLabelEditorialDevolver().setText("Editorial: " + libroActual.getEditorial());
		ventanaCli.getLabelAutorDevolver().setText("Autor: " + libroActual.getAutor());
		ventanaCli.getLabelEjemplaresDevolver().setText("Ejemplares: " + libroActual.getEjemplares());
		ventanaCli.getLabelEstadoDevolver().setText("Estado: " + libroActual.getEstado());
	}

}
