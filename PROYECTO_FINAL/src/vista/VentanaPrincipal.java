/**
 * Ventana principal de inicio de sesion
 */
package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPasswordField contraseñaTexto;
	private JTextField aliasTexto;
	private JButton botonInicioSesion;
	private JLabel inicioLabel;
	private JButton botonRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		botonInicioSesion = new JButton("Iniciar sesi\u00F3n");
		botonInicioSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		botonInicioSesion.setBounds(104, 165, 115, 23);
		contentPane.add(botonInicioSesion);

		aliasTexto = new JTextField();
		aliasTexto.setForeground(new Color(192, 192, 192));
		aliasTexto.setBounds(104, 64, 222, 31);
		contentPane.add(aliasTexto);

		contraseñaTexto = new JPasswordField();
		contraseñaTexto.setBounds(104, 109, 222, 31);
		contentPane.add(contraseñaTexto);

		inicioLabel = new JLabel("Centro Civico");
		inicioLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		inicioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inicioLabel.setBounds(132, 11, 156, 42);
		contentPane.add(inicioLabel);

		botonRegistro = new JButton("Registrarse");
		botonRegistro.setFont(new Font("Arial", Font.PLAIN, 12));
		botonRegistro.setBounds(223, 165, 103, 23);
		contentPane.add(botonRegistro);

	}

	public JButton getBotonRegistro() {
		return botonRegistro;
	}

	public void setBotonRegistro(JButton botonRegistro) {
		this.botonRegistro = botonRegistro;
	}

	public JButton getBotonInicioSesion() {
		return botonInicioSesion;
	}

	public void setBotonInicioSesion(JButton botonInicioSesion) {
		this.botonInicioSesion = botonInicioSesion;
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

	public void setContraseñaTexto(JPasswordField contraseñaTexto) {
		this.contraseñaTexto = contraseñaTexto;
	}
}
