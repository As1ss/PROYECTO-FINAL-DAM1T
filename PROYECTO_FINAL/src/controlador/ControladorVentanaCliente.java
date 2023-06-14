package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import modelo.Libro;
import modelo.OperacionesAdministrador;
import modelo.OperacionesCliente;
import modelo.OperacionesUsuario;
import modelo.Usuario;
import vista.VentanaCliente;

public class ControladorVentanaCliente implements ActionListener {

	VentanaCliente ventanaCli;
	OperacionesCliente operacionesCli;
	OperacionesAdministrador operacionesAdmin;
	OperacionesUsuario operacionesUsu;
	private Usuario usu;

	public ControladorVentanaCliente(Usuario usu) {
		this.usu = usu;
		System.out.println(usu.getAlias());
		operacionesUsu = new OperacionesUsuario();
		operacionesUsu.cargarUsuarios();
		operacionesAdmin = new OperacionesAdministrador();
		operacionesCli = new OperacionesCliente(operacionesAdmin);
		ventanaCli = new VentanaCliente();
		ventanaCli.setTitle("cliente");
		ventanaCli.getBtnDevolucion().addActionListener(this);
		ventanaCli.getBtnDevolver().addActionListener(this);
		ventanaCli.getBtnPedido().addActionListener(this);
		ventanaCli.getBtnPedir().addActionListener(this);
		ventanaCli.setVisible(true);
		agregarLibrosPedido();
		agregarLibrosDevolucion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventanaCli.getBtnDevolucion()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelDevolucion");
			agregarLibrosDevolucion();

		}
		if (e.getSource() == ventanaCli.getBtnPedido()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelPedido");
		}
		if (e.getSource() == ventanaCli.getBtnPedir()) {
			String valor = (String) ventanaCli.getListPedido().getSelectedValue();
			if (usu.getDisponibilidadPrestamo()) {
				for (Entry<Integer, Libro> entry : operacionesAdmin.getListaLibros().entrySet()) {
					Libro libro = entry.getValue();
					if (libro.getTitulo().equals(valor)) {
						operacionesCli.cogerLibro(entry.getKey(), usu);
						operacionesUsu.guardarUsuarios();
						JOptionPane.showMessageDialog(ventanaCli, "Libro " + libro.getTitulo() + " pedido.");
						System.out.println(usu.getDisponibilidadPrestamo());

					}
				}
			} else {
				JOptionPane.showMessageDialog(ventanaCli, "No puedes coger el libro ya que posees uno actualmente.");
			}
			System.out.println(usu.getLibroPrestado().getTitulo());

		}
		if (e.getSource() == ventanaCli.getBtnDevolver()) {
			String valor = (String) ventanaCli.getListDevolucion().getSelectedValue();
			if (!valor.equals("No tienes libros en tu posesión")) {
				for (Entry<Integer, Libro> entry : operacionesAdmin.getListaLibros().entrySet()) {
					Libro libro = entry.getValue();
					if (libro.getTitulo().equals(valor)) {
						operacionesCli.devolverLibro(entry.getKey(), usu);
						operacionesUsu.guardarUsuarios();
						JOptionPane.showMessageDialog(ventanaCli, "Libro " + libro.getTitulo() + " devuelto.");
						System.out.println(usu.getDisponibilidadPrestamo());
						break; // Se encontró el libro, se sale del bucle
					}
				}
			} else {
				JOptionPane.showMessageDialog(ventanaCli, "No tienes libros para devolver.");
			}
			System.out.println(usu.getLibroPrestado());

		}
	}

	public void agregarLibrosPedido() {
		ventanaCli.getListModelPedido().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaCli.getListModelPedido().addElement(titulo.getTitulo());
		}
	}

	public void agregarLibrosDevolucion() {
	    ventanaCli.getListModelDevolucion().removeAllElements();
	    if (usu.getLibroPrestado() != null) {
	        ventanaCli.getListModelDevolucion().addElement(usu.getLibroPrestado().getTitulo());
	        System.out.println(usu.getLibroPrestado().getTitulo());
	    } else {
	        ventanaCli.getListModelDevolucion().addElement("No tienes libros en tu posesión");
	    }
	}

}
