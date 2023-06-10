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
