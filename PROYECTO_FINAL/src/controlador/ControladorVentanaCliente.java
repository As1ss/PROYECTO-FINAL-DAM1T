/**
 * En esta clase podremos interactuar con un usuario cliente para poder consultar los libros disponibles , pedir un libro y devolverlo 
 * Todo esto se almacenará en un fichero denominado historial.txt en el cual figurarán el alias del usuario, el titulo del
 * libro pedido o devuelto y la fecha en la que se ha realizado el pedido o la devolución.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Libro;
import modelo.OperacionesAdministrador;
import modelo.OperacionesCliente;
import modelo.OperacionesUsuario;
import modelo.RegistroFechas;
import modelo.Usuario;
import vista.VentanaCliente;

public class ControladorVentanaCliente implements ActionListener, ListSelectionListener {

	VentanaCliente ventanaCli;
	OperacionesCliente operacionesCli;
	OperacionesAdministrador operacionesAdmin;
	OperacionesUsuario operacionesUsu;
	private Usuario usu;
	RegistroFechas registroF;

	public ControladorVentanaCliente(Usuario usu, OperacionesUsuario operacionesUsu) {
		this.usu = usu;
		this.operacionesUsu = operacionesUsu;
		registroF = new RegistroFechas();
		operacionesAdmin = new OperacionesAdministrador();
		operacionesCli = new OperacionesCliente(operacionesAdmin, operacionesUsu);
		ventanaCli = new VentanaCliente();
		ventanaCli.setTitle("Usuario: " + usu.getAlias());
		ventanaCli.getBtnDevolucion().addActionListener(this);
		ventanaCli.getBtnDevolver().addActionListener(this);
		ventanaCli.getBtnPedido().addActionListener(this);
		ventanaCli.getBtnPedir().addActionListener(this);
		ventanaCli.getListPedido().addListSelectionListener(this);
		ventanaCli.getListDevolucion().addListSelectionListener(this);
		ventanaCli.setVisible(true);
		agregarLibrosPedido();
		agregarLibrosDevolucion();
	}

	/**
	 * Método actionPerformed que maneja los eventos de acción generados por los
	 * botones de la ventana. Realiza las operaciones correspondientes según el
	 * botón presionado.
	 * 
	 * @param e el evento de acción generado
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventanaCli.getBtnDevolucion()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelDevolucion");
			agregarLibrosPedido();
			agregarLibrosDevolucion();

		}
		if (e.getSource() == ventanaCli.getBtnPedido()) {

			ventanaCli.getCardLayout().show(ventanaCli.getPanelGeneral(), "panelPedido");
			agregarLibrosPedido();
			agregarLibrosDevolucion();
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
						registroF.guardarRegistro(usu.getAlias(), libro.getTitulo(),
								String.valueOf(LocalDateTime.now()), "");

					}
				}
			} else {
				JOptionPane.showMessageDialog(ventanaCli, "No puedes coger el libro ya que posees uno actualmente.");
			}

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
						registroF.guardarRegistro(usu.getAlias(), libro.getTitulo(), "",
								String.valueOf(LocalDateTime.now()));
						break; // Se encontró el libro, se sale del bucle
					}
				}
			} else {
				JOptionPane.showMessageDialog(ventanaCli, "No tienes libros para devolver.");
			}

		}
	}

	/**
	 * Método que agrega los títulos de los libros disponibles en el JList del panel
	 * Pedido
	 */
	public void agregarLibrosPedido() {
		ventanaCli.getListModelPedido().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaCli.getListModelPedido().addElement(titulo.getTitulo());
		}
	}

	/**
	 * Método que agrega los títulos de los libros disponibles en el JList del panel
	 * Devolucion
	 */
	public void agregarLibrosDevolucion() {
		ventanaCli.getListModelDevolucion().removeAllElements();
		if (usu.getLibroPrestado() != null) {
			ventanaCli.getListModelDevolucion().addElement(usu.getLibroPrestado().getTitulo());

		} else {
			ventanaCli.getListModelDevolucion().addElement("No tienes libros en tu posesión");
			ventanaCli.getLabelTituloDevolver().setText("Titulo: ");
			ventanaCli.getLabelAutorDevolver().setText("Autor: ");
			ventanaCli.getLabelEditorialDevolver().setText("Editorial: ");
			ventanaCli.getLabelEjemplaresDevolver().setText("Ejemplares: ");
			ventanaCli.getLabelEstadoDevolver().setText("Estado: ");
		}
	}

	/**
	 * Eventos en los cuales se muestran la información tanto en etiquetas como
	 * campos de texto del libro seleccionado de la Jlist
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == ventanaCli.getListPedido()) {
			String selectedValue = (String) ventanaCli.getListPedido().getSelectedValue();

			for (Libro libro : operacionesAdmin.getListaLibros().values()) {
				if (libro.getTitulo().equals(selectedValue)) {
					ventanaCli.getLabelTituloPedir().setText("Titulo: " + libro.getTitulo());
					ventanaCli.getLabelAutorPedir().setText("Autor: " + libro.getAutor());
					ventanaCli.getLabelEditorialPedir().setText("Editorial: " + libro.getEditorial());
					ventanaCli.getLabelEjemplaresPedir().setText("Ejemplares: " + libro.getEjemplares());
					ventanaCli.getLabelEstadoPedir().setText("Estado: " + libro.getEstado());
				}
			}
		}
		if (e.getSource() == ventanaCli.getListDevolucion()) {
			String selectedValue = (String) ventanaCli.getListDevolucion().getSelectedValue();

			for (Libro libro : operacionesAdmin.getListaLibros().values()) {
				if (libro.getTitulo().equals(selectedValue)) {
					ventanaCli.getLabelTituloDevolver().setText("Titulo: " + libro.getTitulo());
					ventanaCli.getLabelAutorDevolver().setText("Autor: " + libro.getAutor());
					ventanaCli.getLabelEditorialDevolver().setText("Editorial: " + libro.getEditorial());
					ventanaCli.getLabelEjemplaresDevolver().setText("Ejemplares: " + libro.getEjemplares());
					ventanaCli.getLabelEstadoDevolver().setText("Estado: " + libro.getEstado());
				}
			}
		}

	}

}
