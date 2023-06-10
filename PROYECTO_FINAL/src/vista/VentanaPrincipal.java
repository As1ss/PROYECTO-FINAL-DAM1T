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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPasswordField contraseñaTexto;
	private JTextField aliasTexto;

	private JButton botonInicioSesion;

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
		botonInicioSesion.setBounds(122, 170, 177, 23);
		contentPane.add(botonInicioSesion);

		aliasTexto = new JTextField();
		aliasTexto.setForeground(new Color(192, 192, 192));
		aliasTexto.setBounds(122, 64, 177, 31);
		contentPane.add(aliasTexto);

		contraseñaTexto = new JPasswordField();
		contraseñaTexto.setBounds(122, 110, 177, 31);
		contentPane.add(contraseñaTexto);

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
