
/**
 * Esta clase actúa como controlador para la ventana de administrador de la aplicación.
 * Maneja eventos y acciones relacionadas con la ventana de administrador.
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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

	/**
	 * Constructor de la clase ControladorVentanaAdministrador. Crea una instancia
	 * de OperacionesAdministrador y VentanaAdministrador, y configura los listeners
	 * de eventos en los componentes de la ventana.
	 */
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
		ventanaAdmin.getBtnLimpiar().addActionListener(this);
		ventanaAdmin.getBtnSelectImagen().addActionListener(this);
		ventanaAdmin.setVisible(true);
		agregarLibrosConsulta();
		agregarLibrosModificar();
		añadirCategoriasJCombo();
		ventanaAdmin.getBtnLimpiar().doClick();

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

						break; // Termina el bucle después de encontrar y eliminar el libro
					}
				}
			}
			agregarLibrosConsulta();
			agregarLibrosModificar();

		}
		if (e.getSource() == ventanaAdmin.getBotonGuardarModificar()) {
			String valor = (String) ventanaAdmin.getListModificar().getSelectedValue();

			for (Entry<Integer, Libro> entry : operacionesAdmin.getListaLibros().entrySet()) {
				Libro libro = entry.getValue();
				if (libro.getTitulo().equals(valor)) {
					String titulo = ventanaAdmin.getTextoTituloModificar().getText();
					String autor = ventanaAdmin.getTextoAutorModificar().getText();
					String editorial = ventanaAdmin.getTextoEditorialModificar().getText();
					int ejemplares = Integer.parseInt(ventanaAdmin.getTextoEjemplaresModificar().getText());
					String estado = ventanaAdmin.getComboBoxModificar().getSelectedItem().toString();

					int opcion = JOptionPane.showConfirmDialog(ventanaAdmin,
							"¿Seguro que quieres modificar el producto: " + libro.getTitulo() + "?");

					if (opcion == JOptionPane.YES_OPTION) {

						operacionesAdmin.modificarLibro(libro.getId(), titulo, autor, editorial, ejemplares, estado);

						break; // Termina el bucle después de encontrar y eliminar el libro
					}
				}
			}
			agregarLibrosConsulta();
			agregarLibrosModificar();

		}
		if (e.getSource() == ventanaAdmin.getBtnLimpiar()) {
			ventanaAdmin.getTftTitulo().setText("");
			ventanaAdmin.getTftAutor().setText("");
			ventanaAdmin.getTftEditorial().setText("");
			ventanaAdmin.getTftEjemplares().setText("");
			ventanaAdmin.getComboBox().setSelectedItem("Nuevo");
			ImageIcon imagen = new ImageIcon("src/images/default.png");
			ImageIcon imagenRedimensionada = redimensionarImagen(imagen, 122, 142);
			ventanaAdmin.getImagenLibroAñadir().setIcon(imagenRedimensionada);
			ventanaAdmin.getLblDirImagen().setText("src/images/default.png");
		}
		if (e.getSource() == ventanaAdmin.getBtnSelectImagen()) {

			JFileChooser seleccionImg = new JFileChooser();
			int resultado = seleccionImg.showOpenDialog(null);

			if (resultado == JFileChooser.APPROVE_OPTION) {
				File archivoSeleccionado = seleccionImg.getSelectedFile();
				String direccionImagen = archivoSeleccionado.getAbsolutePath();
				ImageIcon imagen = new ImageIcon(direccionImagen);
				ImageIcon imagenRedimensionada = redimensionarImagen(imagen, 122, 142);
				ventanaAdmin.getLblDirImagen().setText(direccionImagen);
				ventanaAdmin.getImagenLibroAñadir().setIcon(imagenRedimensionada);

			}
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

	/**
	 * Agrega los títulos de los libros al JList del panel Consulta
	 */

	public void agregarLibrosConsulta() {
		ventanaAdmin.getListModel().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaAdmin.getListModel().addElement(titulo.getTitulo());

		}

	}

	/**
	 * Agrega los títulos de los libros al JList del panel Modificar
	 */

	public void agregarLibrosModificar() {
		ventanaAdmin.getListModelModificar().removeAllElements();
		for (Libro titulo : operacionesAdmin.getListaLibros().values()) {
			ventanaAdmin.getListModelModificar().addElement(titulo.getTitulo());

		}

	}

	/**
	 * Añade las opciones de estado al JComboBox del panel Modificar
	 */
	public void añadirCategoriasJCombo() {

		for (int i = 0; i < operacionesAdmin.getOpciones().length; i++) {
			ventanaAdmin.getComboBoxModificar().addItem(operacionesAdmin.getOpciones()[i]);
			ventanaAdmin.getComboBox().addItem(operacionesAdmin.getOpciones()[i]);

		}
	}

	/**
	 * Redimensiona una imagen a las dimensiones especificadas.
	 *
	 * @param icon  ImageIcon de la imagen a redimensionar.
	 * @param ancho Ancho deseado de la imagen redimensionada.
	 * @param alto  Alto deseado de la imagen redimensionada.
	 * @return ImageIcon de la imagen redimensionada.
	 */
	public ImageIcon redimensionarImagen(ImageIcon icon, int ancho, int alto) {
		Image imagen = icon.getImage();
		Image redimension = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(redimension);

	}

}
