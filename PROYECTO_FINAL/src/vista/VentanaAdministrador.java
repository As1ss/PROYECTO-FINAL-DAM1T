package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo.Libro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelConsulta;
	private JPanel panelAñadir;
	private JPanel panelModificar;
	private CardLayout cardLayout;
	private JLabel imagenLibro;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private JLabel labelTitulo;
	private JLabel labelEditorial;
	private JLabel labelAutor;
	private JLabel labelEjemplares;
	private JLabel labelEstado;
	private JButton botonConsultar;
	private JButton botonAñadir;

	private JButton botonModificar;
	
	private JLabel imagenLibroAñadir;
	private JLabel labelTituloAñadir;
	private JLabel labelEditorialAñadir;
	private JLabel labelAutorAñadir;
	private JLabel labelEjemplaresAñadir;
	private JButton btnSelectImagen;
	private JLabel lblDirImagen;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JTextField tftTitulo;
	private JTextField tftAutor;
	private JTextField tftEditorial;
	private JTextField tftEjemplares;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Crear el CardLayout y el panel principal
		cardLayout = new CardLayout();
		panelPrincipal = new JPanel(cardLayout);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panelPrincipal, BorderLayout.CENTER);

		// Crear los paneles secundarios
		panelConsulta = new JPanel();
		panelConsulta.setBackground(new Color(255, 255, 255));
		panelPrincipal.add(panelConsulta, "panelConsultar");
		panelConsulta.setLayout(null);

		imagenLibro = new JLabel();
		imagenLibro.setBounds(31, 11, 122, 142);
		Libro test = new Libro("Libro1", "Pepe", "PepeProductions", 5, "Buen estado");
		imagenLibro.setIcon(test.getImg());
		panelConsulta.add(imagenLibro);

		botonAnterior = new JButton("<=");
		botonAnterior.setBounds(15, 164, 66, 23);
		panelConsulta.add(botonAnterior);

		botonSiguiente = new JButton("=>");
		botonSiguiente.setBounds(87, 164, 66, 23);
		panelConsulta.add(botonSiguiente);

		labelTitulo = new JLabel("Ttulo: ");
		labelTitulo.setBounds(222, 23, 177, 14);
		panelConsulta.add(labelTitulo);

		labelEditorial = new JLabel("Editorial:");
		labelEditorial.setBounds(222, 96, 177, 14);
		panelConsulta.add(labelEditorial);

		labelAutor = new JLabel("Autor: ");
		labelAutor.setBounds(222, 58, 177, 14);
		panelConsulta.add(labelAutor);

		labelEjemplares = new JLabel("Ejemplares: ");
		labelEjemplares.setBounds(222, 133, 177, 14);
		panelConsulta.add(labelEjemplares);

		labelEstado = new JLabel("Estado: ");
		labelEstado.setBounds(222, 173, 177, 14);
		panelConsulta.add(labelEstado);

		panelAñadir = new JPanel();
		panelAñadir.setBackground(Color.WHITE);
		panelPrincipal.add(panelAñadir, "panelAñadir");
		panelAñadir.setLayout(null);
		
		imagenLibroAñadir = new JLabel();
		imagenLibroAñadir.setIcon(test.getImg());
		imagenLibroAñadir.setBounds(26, 11, 122, 142);
		panelAñadir.add(imagenLibroAñadir);
		
		labelTituloAñadir = new JLabel("Título: ");
		labelTituloAñadir.setBounds(217, 23, 177, 14);
		panelAñadir.add(labelTituloAñadir);
		
		labelEditorialAñadir = new JLabel("Editorial:");
		labelEditorialAñadir.setBounds(217, 96, 177, 14);
		panelAñadir.add(labelEditorialAñadir);
		
		labelAutorAñadir = new JLabel("Autor: ");
		labelAutorAñadir.setBounds(217, 58, 177, 14);
		panelAñadir.add(labelAutorAñadir);
		
		labelEjemplaresAñadir = new JLabel("Ejemplares: ");
		labelEjemplaresAñadir.setBounds(217, 133, 177, 14);
		panelAñadir.add(labelEjemplaresAñadir);
		
		btnSelectImagen = new JButton("Seleccionar imagen");
		btnSelectImagen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSelectImagen.setBounds(26, 169, 122, 23);
		panelAñadir.add(btnSelectImagen);
		
		lblDirImagen = new JLabel(imagenLibroAñadir.getIcon().toString());
		lblDirImagen.setEnabled(false);
		lblDirImagen.setBounds(26, 193, 231, 14);
		panelAñadir.add(lblDirImagen);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(325, 173, 89, 34);
		panelAñadir.add(btnGuardar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon("src/images/Limpiar.png"));
	
	
		btnLimpiar.setBounds(284, 173, 35, 34);
		panelAñadir.add(btnLimpiar);
		
		tftTitulo = new JTextField();
		tftTitulo.setBounds(256, 20, 138, 20);
		panelAñadir.add(tftTitulo);
		tftTitulo.setColumns(10);
		
		tftAutor = new JTextField();
		tftAutor.setColumns(10);
		tftAutor.setBounds(256, 55, 138, 20);
		panelAñadir.add(tftAutor);
		
		tftEditorial = new JTextField();
		tftEditorial.setColumns(10);
		tftEditorial.setBounds(276, 93, 118, 20);
		panelAñadir.add(tftEditorial);
		
		tftEjemplares = new JTextField();
		tftEjemplares.setColumns(10);
		tftEjemplares.setBounds(298, 130, 96, 20);
		panelAñadir.add(tftEjemplares);

		panelModificar = new JPanel();
		panelModificar.setBackground(Color.BLUE);
		panelPrincipal.add(panelModificar, "panelModificar");

		botonConsultar = new JButton("Consultar");
		botonAñadir = new JButton("A\u00F1adir");
		botonModificar = new JButton("Modificar");

		// Agregar los botones al panel principal
		JPanel panelBotones = new JPanel();
		panelBotones.add(botonConsultar);
		panelBotones.add(botonAñadir);
		panelBotones.add(botonModificar);
		contentPane.add(panelBotones, BorderLayout.NORTH);

	}

	public JPanel getPanelAñadir() {
		return panelAñadir;
	}

	public void setPanelAñadir(JPanel panelAñadir) {
		this.panelAñadir = panelAñadir;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JLabel getImagenLibro() {
		return imagenLibro;
	}

	public void setImagenLibro(JLabel imagenLibro) {
		this.imagenLibro = imagenLibro;
	}

	public JButton getBotonAnterior() {
		return botonAnterior;
	}

	public void setBotonAnterior(JButton botonAnterior) {
		this.botonAnterior = botonAnterior;
	}

	public JButton getBotonSiguiente() {
		return botonSiguiente;
	}

	public void setBotonSiguiente(JButton botonSiguiente) {
		this.botonSiguiente = botonSiguiente;
	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public JLabel getLabelEditorial() {
		return labelEditorial;
	}

	public void setLabelEditorial(JLabel labelEditorial) {
		this.labelEditorial = labelEditorial;
	}

	public JLabel getLabelAutor() {
		return labelAutor;
	}

	public void setLabelAutor(JLabel labelAutor) {
		this.labelAutor = labelAutor;
	}

	public JLabel getLabelEjemplares() {
		return labelEjemplares;
	}

	public void setLabelEjemplares(JLabel labelEjemplares) {
		this.labelEjemplares = labelEjemplares;
	}

	public JLabel getLabelEstado() {
		return labelEstado;
	}

	public void setLabelEstado(JLabel labelEstado) {
		this.labelEstado = labelEstado;
	}

	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	public void setBotonConsultar(JButton botonConsultar) {
		this.botonConsultar = botonConsultar;
	}

	public JButton getBotonAñadir() {
		return botonAñadir;
	}

	public void setBotonAñadir(JButton botonAñadir) {
		this.botonAñadir = botonAñadir;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JTextField getTftTitulo() {
		return tftTitulo;
	}

	public JTextField getTftAutor() {
		return tftAutor;
	}

	public JTextField getTftEditorial() {
		return tftEditorial;
	}

	public JTextField getTftEjemplares() {
		return tftEjemplares;
	}

	public JLabel getImagenLibroAñadir() {
		return imagenLibroAñadir;
	}

	public JLabel getLabelTituloAñadir() {
		return labelTituloAñadir;
	}

	public JLabel getLabelEditorialAñadir() {
		return labelEditorialAñadir;
	}

	public JLabel getLabelAutorAñadir() {
		return labelAutorAñadir;
	}

	public JLabel getLabelEjemplaresAñadir() {
		return labelEjemplaresAñadir;
	}

	public JButton getBtnSelectImagen() {
		return btnSelectImagen;
	}

	public JLabel getLblDirImagen() {
		return lblDirImagen;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	
}

