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

	public ControladorVentanaPrincipal() {
		operacionesUsu = new OperacionesUsuario();
		ventana = new VentanaPrincipal();
		ventana.setTitle("VentanaPrincipal");
		añadirTextosPredefinidos();
		ventana.getAliasTexto().addMouseListener(this);
		ventana.getContraseñaTexto().addMouseListener(this);
		ventana.getBotonInicioSesion().addActionListener(this);
		ventana.setVisible(true);
	}

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
			HashMap<String, Usuario> usuariosAlmacenados = operacionesUsu.cargarUsuarios();

			// Verificar la autenticación del usuario
			Usuario usuario = usuariosAlmacenados.get(alias);
			if (usuario != null && usuario.getContraseña().equals(contraseña)) {
				// Iniciar la nueva ventana aquí
				// Por ejemplo, crear una instancia de la ventana de inicio de sesión exitoso y
				// mostrarla
				JOptionPane.showMessageDialog(null, "INICIO DE SESION SATISFACTORIO.");
			} else {
				// Mostrar mensaje de error de inicio de sesión
				JOptionPane.showMessageDialog(ventana, "Credenciales de inicio de sesión inválidas",
						"Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ventana.getAliasTexto()) {
			if (ventana.getAliasTexto().getText().equals("👤Usuario")) {
				ventana.getAliasTexto().setText("");
				ventana.getAliasTexto().setForeground(Color.BLACK);
			}

		}
		if (e.getSource() == ventana.getContraseñaTexto()) {
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