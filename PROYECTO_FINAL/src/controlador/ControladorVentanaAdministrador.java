package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Libro;
import modelo.OperacionesAdministrador;
import modelo.Usuario;
import vista.VentanaAdministrador;

public class ControladorVentanaAdministrador implements ActionListener, ListSelectionListener {
	OperacionesAdministrador operacionesAdmin;
	VentanaAdministrador ventanaAdmin;

	public ControladorVentanaAdministrador() {
		operacionesAdmin = new OperacionesAdministrador();
		ventanaAdmin = new VentanaAdministrador();
		ventanaAdmin.setTitle("Administracion");
		ventanaAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaAdmin.getBotonConsultar().addActionListener(this);
		ventanaAdmin.getBotonAñadir().addActionListener(this);
		ventanaAdmin.getBotonModificar().addActionListener(this);
		ventanaAdmin.getBtnGuardar().addActionListener(this);
		ventanaAdmin.getList().addListSelectionListener(this);
		ventanaAdmin.getListModificar().addListSelectionListener(this);
		ventanaAdmin.getBotonBorrarModificar().addActionListener(this);
		ventanaAdmin.getBotonGuardarModificar().addActionListener(this);
		ventanaAdmin.setVisible(true);
		agregarLibrosConsulta();
		agregarLibrosModificar();
		añadirCategoriasJCombo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventanaAdmin.getBotonConsultar()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelConsultar");

		}
		if (e.getSource() == ventanaAdmin.getBotonAñadir()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelAñadir");
			operacionesAdmin.mostrarLibros();
		}
		if (e.getSource() == ventanaAdmin.getBotonModificar()) {
			ventanaAdmin.getCardLayout().show(ventanaAdmin.getPanelPrincipal(), "panelModificar");
		}

		if (e.getSource() == ventanaAdmin.getBtnGuardar()) {
			String titulo = ventanaAdmin.getTftTitulo().getText();
			String autor = ventanaAdmin.getTftAutor().getText();
			String editorial = ventanaAdmin.getTftEditorial().getText();
			int ejemplares = Integer.parseInt(ventanaAdmin.getTftEjemplares().getText());
			String estado = ventanaAdmin.getComboBox().getSelectedItem().toString();
			operacionesAdmin.darDeAltaLibro(titulo, autor, editorial, ejemplares, estado);
			JOptionPane.showMessageDialog(null, "Libro :" + titulo + " añadido correctamente.");

		}
		if (e.getSource() == ventanaAdmin.getBotonBorrarModificar()) {
			String valor = (String) ventanaAdmin.getListModificar().getSelectedValue();

			for (Entry<Integer, Libro> entry : operacionesAdmin.getListaLibros().entrySet()) {
				Libro libro = entry.getValue();
				if (libro.getTitulo().equals(valor)) {
					int opcion = JOptionPane.showConfirmDialog(ventanaAdmin,
							"¿Seguro que quieres eliminar el producto: " + libro.getTitulo() + "?");

					if (opcion == JOptionPane.YES_OPTION) {
						operacionesAdmin.darDeBajaLibro(entry.getKey());
						agregarLibrosConsulta();
						agregarLibrosModificar();

						break; // Termina el bucle después de encontrar y eliminar el libro
					}
				}
			}
			agregarLibrosConsulta();
			agregarLibrosModificar();

		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == ventanaAdmin.getList()) {
			String selectedValue = (String) ventanaAdmin.getList().getSelectedValue();

			for (Libro libro : operacionesAdmin.getListaLibros().values()) {
				if (libro.getTitulo().equals(selectedValue)) {
					ventanaAdmin.getLabelTitulo().setText("Titulo: " + libro.getTitulo());
					ventanaAdmin.getLabelAutor().setText("Autor: " + libro.getAutor());
					ventanaAdmin.getLabelEditorial().setText("Editorial: " + libro.getEditorial());
					ventanaAdmin.getLabelEjemplares().setText("Ejemplares: " + libro.getEjemplares());
					ventanaAdmin.getLabelEstado().setText("Estado: " + libro.getEstado());
				}
			}
		}

		if (e.getSource() == ventanaAdmin.getListModificar()) {
			String selectedValue = (String) ventanaAdmin.getListModificar().getSelectedValue();
			System.out.println(selectedValue);

			for (Libro libro : operacionesAdmin.getListaLibros().values()) {
				if (libro.getTitulo().equals(selectedValue)) {
					ventanaAdmin.getTextoTituloModificar().setText(libro.getTitulo());
					ventanaAdmin.getTextoAutorModificar().setText(libro.getAutor());
					ventanaAdmin.getTextoEditorialModificar().setText(libro.getEditorial());
					ventanaAdmin.getTextoEjemplaresModificar().setText(String.valueOf(libro.getEjemplares()));
					ventanaAdmin.getComboBoxModificar().setSelectedItem(libro.getEstado());

				}
			}
		}
	}

	public void agregarLibrosConsulta() {
		ventanaAdmin.getListModel().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaAdmin.getListModel().addElement(titulo.getTitulo());
			System.out.println(titulo.getTitulo());
		}

	}

	public void agregarLibrosModificar() {
		ventanaAdmin.getListModelModificar().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaAdmin.getListModelModificar().addElement(titulo.getTitulo());
			System.out.println(titulo.getTitulo());
		}

	}

	public void añadirCategoriasJCombo() {

		for (int i = 0; i < operacionesAdmin.getOpciones().length; i++) {
			ventanaAdmin.getComboBoxModificar().addItem(operacionesAdmin.getOpciones()[i]);
			ventanaAdmin.getComboBox().addItem(operacionesAdmin.getOpciones()[i]);

		}
	}

}
