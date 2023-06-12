package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import modelo.Libro;
import modelo.OperacionesAdministrador;
import modelo.Usuario;
import vista.VentanaAdministrador;

public class ControladorVentanaAdministrador implements ActionListener {
	OperacionesAdministrador operacionesAdmin;
	VentanaAdministrador ventanaAdmin;
	private HashMap<Integer, Libro> libros;
	private int indiceActual;

	public ControladorVentanaAdministrador() {
		operacionesAdmin = new OperacionesAdministrador();
		ventanaAdmin = new VentanaAdministrador();
		ventanaAdmin.setTitle("Administracion");
		ventanaAdmin.getBotonConsultar().addActionListener(this);
		ventanaAdmin.getBotonAñadir().addActionListener(this);
		ventanaAdmin.getBotonModificar().addActionListener(this);
		ventanaAdmin.getBotonAnterior().addActionListener(this);
		ventanaAdmin.getBotonSiguiente().addActionListener(this);
		ventanaAdmin.setVisible(true);
		libros = operacionesAdmin.cargarLibros();
		indiceActual = 0;
		mostrarDetalleLibro();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventanaAdmin.getBotonConsultar()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelConsultar");
		}
		if (e.getSource() == ventanaAdmin.getBotonAñadir()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelAñadir");
		}
		if (e.getSource() == ventanaAdmin.getBotonModificar()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelModificar");
		}
		if (e.getSource() == ventanaAdmin.getBotonAnterior()) {
			if (indiceActual > 0) {
				indiceActual--;
			} else {
				indiceActual = libros.size() - 1;
			}
			mostrarDetalleLibro();
		}
		if (e.getSource() == ventanaAdmin.getBotonSiguiente()) {
			if (indiceActual < libros.size() - 1) {
				indiceActual++;
			} else {
				indiceActual = 0;
			}
			mostrarDetalleLibro();
		}
		if (e.getSource()==ventanaAdmin.getBtnGuardar()) {
			String titulo=ventanaAdmin.getTftTitulo().getText();
			String autor = ventanaAdmin.getTftAutor().getText();
			String editorial = ventanaAdmin.getTftEditorial().getText();
			int ejemplares = Integer.parseInt(ventanaAdmin.getTftEjemplares().getText());
			
			operacionesAdmin.darDeAltaLibro(null, null, null, indiceActual, null);
		}
	}

	private void mostrarDetalleLibro() {
		Libro libroActual = libros.get(indiceActual);
		ventanaAdmin.getImagenLibro().setIcon(libroActual.getImg());
		ventanaAdmin.getLabelTitulo().setText("Título: " + libroActual.getTitulo());
		ventanaAdmin.getLabelEditorial().setText("Editorial: " + libroActual.getEditorial());
		ventanaAdmin.getLabelAutor().setText("Autor: " + libroActual.getAutor());
		ventanaAdmin.getLabelEjemplares().setText("Ejemplares: " + libroActual.getEjemplares());
		ventanaAdmin.getLabelEstado().setText("Estado: " + libroActual.getEstado());
	}

}
