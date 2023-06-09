/**
 * El controlador para la ventana principal de inicio de sesión.
 * Maneja eventos de ratón y acciones de botones para la autenticación de usuarios y registro de nuevos usuarios.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.OperacionesUsuario;
import modelo.Usuario;
import vista.VentanaPrincipal;

public class ControladorVentanaPrincipal implements MouseListener, ActionListener {
	private VentanaPrincipal ventana;
	private OperacionesUsuario operacionesUsu;
	 /**
     * Constructor de la clase ControladorVentanaPrincipal.
     * Crea una instancia de VentanaPrincipal, configura el aspecto y maneja los eventos.
     */
	public ControladorVentanaPrincipal() {
		operacionesUsu = new OperacionesUsuario();
		ventana = new VentanaPrincipal();
		ventana.setTitle("Inicio de sesión");
		añadirTextosPredefinidos();
		ventana.getAliasTexto().addMouseListener(this);
		ventana.getContraseñaTexto().addMouseListener(this);
		ventana.getBotonInicioSesion().addActionListener(this);
		ventana.getBotonRegistro().addActionListener(this);
		ventana.setVisible(true);
	}

	 /**
     * Añade los textos predefinidos "👤Usuario" y "🔒Contraseña" a los campos de texto de la ventana principal.
     */

	private void añadirTextosPredefinidos() {
		ventana.getAliasTexto().setText("👤Usuario");
		ventana.getContraseñaTexto().setEchoChar((char) 0);
		ventana.getContraseñaTexto().setForeground(new Color(192, 192, 192));
		ventana.getContraseñaTexto().setText("🔒Contraseña");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventana.getBotonInicioSesion()) {
			String alias = ventana.getAliasTexto().getText();
			String contraseña = String.valueOf(ventana.getContraseñaTexto().getPassword());
			// Obtener la colección de usuarios almacenados en el archivo
			HashMap<String, Usuario> usuariosAlmacenados = operacionesUsu.getListaUsuarios();
			// Verificar la autenticación del usuario
			Usuario usuario = usuariosAlmacenados.get(alias);
			if (usuario != null && usuario.getContraseña().equals(contraseña)) {
				// Iniciar la nueva ventana aquí
				// Puede variar segun las credenciales sean de Administración o usuarios clientes
				JOptionPane.showMessageDialog(null, "Bienvenid@ " + usuario.getAlias());
				if (usuario.getAlias().equalsIgnoreCase("Admin") && usuario.getContraseña().equalsIgnoreCase("1234")) {
					try {
						new ControladorVentanaAdministrador();
					} catch (Exception e2) {

					}
				} else {
					try {
						new ControladorVentanaCliente(usuario,operacionesUsu);
					} catch (Exception e2) {

					}

				}

				operacionesUsu.guardarUsuarios(); // Actualizar el archivo de usuarios

			} else {
				// Mostrar mensaje de error de inicio de sesión
				JOptionPane.showMessageDialog(ventana, "Credenciales de inicio de sesión inválidas",
						"Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
			}

		}
		if (e.getSource() == ventana.getBotonRegistro()) {
			System.out.println("Se ha pulsado el boton registro");
			try {
				new ControladorVentanaCreacionUsuario(operacionesUsu);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	/**
	 * Eventos de ratón en el cual proporciona la funcionalidad de reemplazar el mensaje de información
	 * por el campo vacío para rellenar con nuestras credenciales
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ventana.getAliasTexto() || ventana.getAliasTexto().getText().equals("")) {
			if (ventana.getAliasTexto().getText().equals("👤Usuario")) {
				ventana.getAliasTexto().setText("");
				ventana.getAliasTexto().setForeground(Color.BLACK);
			}

		}
		if (e.getSource() == ventana.getContraseñaTexto() || ventana.getContraseñaTexto().getPassword().equals("")) {
			JPasswordField contraseñaTexto = ventana.getContraseñaTexto();
			if (String.valueOf(contraseñaTexto.getPassword()).equals("🔒Contraseña")) {
				contraseñaTexto.setText("");
				contraseñaTexto.setEchoChar('*');
				contraseñaTexto.setForeground(Color.BLACK);
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