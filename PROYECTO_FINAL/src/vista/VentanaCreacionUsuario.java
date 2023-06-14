/**
 * Ventana para poder crear usuarios
 */
package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaCreacionUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTexto;
	private JTextField direccionTexto;
	private JTextField aliasTexto;
	private JPasswordField contraseñaTexto;
	private JButton botonAceptar;
	private JButton botonVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacionUsuario frame = new VentanaCreacionUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCreacionUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nombreTexto = new JTextField();
		nombreTexto.setBounds(99, 34, 204, 32);
		contentPane.add(nombreTexto);
		nombreTexto.setColumns(10);

		direccionTexto = new JTextField();
		direccionTexto.setColumns(10);
		direccionTexto.setBounds(99, 81, 256, 32);
		contentPane.add(direccionTexto);

		aliasTexto = new JTextField();
		aliasTexto.setColumns(10);
		aliasTexto.setBounds(99, 128, 204, 32);
		contentPane.add(aliasTexto);

		contraseñaTexto = new JPasswordField();
		contraseñaTexto.setBounds(99, 175, 204, 32);
		contentPane.add(contraseñaTexto);

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(99, 218, 204, 32);
		contentPane.add(botonAceptar);

		botonVolver = new JButton("<=");
		botonVolver.setBounds(10, 11, 49, 42);
		contentPane.add(botonVolver);

		JLabel registroLabel = new JLabel("Registro");
		registroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registroLabel.setBounds(99, 5, 172, 23);
		contentPane.add(registroLabel);
	}

	public JTextField getNombreTexto() {
		return nombreTexto;
	}

	public void setNombreTexto(JTextField nombreTexto) {
		this.nombreTexto = nombreTexto;
	}

	public JTextField getDireccionTexto() {
		return direccionTexto;
	}

	public void setDireccionTexto(JTextField direccionTexto) {
		this.direccionTexto = direccionTexto;
	}

	public JTextField getAliasTexto() {
		return aliasTexto;
	}

	public void setAliasTexto(JTextField aliasTexto) {
		this.aliasTexto = aliasTexto;
	}

	public JPasswordField getContraseñaTexto() {
		return contraseñaTexto;
	}

	public void setContraseña(JPasswordField passwordField) {
		this.contraseñaTexto = passwordField;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

}
