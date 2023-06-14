/**

ControladorVentanaCreacionUsuario es una clase que implementa ActionListener y MouseListener para manejar los eventos y la interacción de la ventana de creación de usuario.

Se encarga de realizar las operaciones necesarias para agregar un nuevo usuario, validar los campos ingresados y mostrar mensajes de confirmación o error.

Esta clase se comunica con la clase OperacionesUsuario y la clase VentanaCreacionUsuario.

@see ActionListener

@see MouseListener

@see OperacionesUsuario

@see VentanaCreacionUsuario
*/
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import modelo.OperacionesUsuario;
import vista.VentanaCreacionUsuario;
import vista.VentanaPrincipal;

public class ControladorVentanaCreacionUsuario implements ActionListener, MouseListener {
	private OperacionesUsuario operacionesUsu;
	private VentanaCreacionUsuario ventanaUsu;

	/**
	 * 
	 * Constructor de la clase ControladorVentanaCreacionUsuario.
	 * 
	 * @param operacionesUsu instancia de la clase OperacionesUsuario para realizar
	 *                       operaciones relacionadas con usuarios
	 */

	public ControladorVentanaCreacionUsuario(OperacionesUsuario operacionesUsu) {
		this.operacionesUsu = operacionesUsu;
		ventanaUsu = new VentanaCreacionUsuario();
		ventanaUsu.setTitle("Creacion Usuario");
		añadirTextosPredefinidos();
		ventanaUsu.getBotonAceptar().addActionListener(this);
		ventanaUsu.getBotonVolver().addActionListener(this);
		ventanaUsu.getNombreTexto().addMouseListener(this);
		ventanaUsu.getDireccionTexto().addMouseListener(this);
		ventanaUsu.getAliasTexto().addMouseListener(this);
		ventanaUsu.getContraseñaTexto().addMouseListener(this);
		ventanaUsu.setVisible(true);

	}

	/**
	 * 
	 * Añade los textos predefinidos a los campos de texto en la ventana de creación
	 * de usuario.
	 */

	private void añadirTextosPredefinidos() {
		ventanaUsu.getNombreTexto().setText("Nombre");
		ventanaUsu.getNombreTexto().setForeground(new Color(192, 192, 192));
		ventanaUsu.getDireccionTexto().setText("Direccion");
		ventanaUsu.getDireccionTexto().setForeground(new Color(192, 192, 192));
		ventanaUsu.getAliasTexto().setText("👤Usuario");
		ventanaUsu.getAliasTexto().setForeground(new Color(192, 192, 192));
		ventanaUsu.getContraseñaTexto().setEchoChar((char) 0);
		ventanaUsu.getContraseñaTexto().setForeground(new Color(192, 192, 192));
		ventanaUsu.getContraseñaTexto().setText("🔒Contraseña");

	}

	/**
	 * 
	 * Maneja los eventos de acción ocurridos en la ventana de creación de usuario.
	 * 
	 * @param es el evento de acción que ocurrió
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventanaUsu.getBotonAceptar()) {
			String alias = ventanaUsu.getAliasTexto().getText();
			String contraseña = String.valueOf(ventanaUsu.getContraseñaTexto().getPassword());
			String nombre = ventanaUsu.getNombreTexto().getText();
			String direccion = ventanaUsu.getDireccionTexto().getText();
			if (!alias.isEmpty() && !contraseña.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty()) {
				operacionesUsu.agregarUsuario(alias, contraseña, nombre, direccion);
				JOptionPane.showInternalMessageDialog(null, "El usuario: " + alias + " ha sido añadido correctamente");
				operacionesUsu.guardarUsuarios();
			} else {
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
			}

		}
		if (e.getSource() == ventanaUsu.getBotonVolver()) {
			ventanaUsu.dispose();
		}

	}

	/**
	 * Eventos de ratón en el cual proporciona la funcionalidad de reemplazar el
	 * mensaje de información por el campo vacío para rellenar con nuestras
	 * credenciales
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ventanaUsu.getAliasTexto() || ventanaUsu.getAliasTexto().getText().equals("")) {
			if (ventanaUsu.getAliasTexto().getText().equals("👤Usuario")) {
				ventanaUsu.getAliasTexto().setText("");
				ventanaUsu.getAliasTexto().setForeground(Color.BLACK);
			}

		}
		if (e.getSource() == ventanaUsu.getContraseñaTexto()
				|| ventanaUsu.getContraseñaTexto().getPassword().equals("")) {
			JPasswordField contraseñaTexto = ventanaUsu.getContraseñaTexto();
			if (String.valueOf(contraseñaTexto.getPassword()).equals("🔒Contraseña")) {
				contraseñaTexto.setText("");
				contraseñaTexto.setEchoChar('*');
				contraseñaTexto.setForeground(Color.BLACK);
			}
		}
		if (e.getSource() == ventanaUsu.getNombreTexto()) {
			if (ventanaUsu.getNombreTexto().getText().equals("Nombre")
					|| ventanaUsu.getNombreTexto().getText().equals("")) {
				ventanaUsu.getNombreTexto().setText("");
				ventanaUsu.getNombreTexto().setForeground(Color.BLACK);
			}

		}
		if (e.getSource() == ventanaUsu.getDireccionTexto()) {
			if (ventanaUsu.getDireccionTexto().getText().equals("Direccion")
					|| ventanaUsu.getDireccionTexto().getText().equals("")) {
				ventanaUsu.getDireccionTexto().setText("");
				ventanaUsu.getDireccionTexto().setForeground(Color.BLACK);
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
