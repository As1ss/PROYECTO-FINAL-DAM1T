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
	private CardLayout cardLayout;
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
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JPanel panelModificar;
	private JLabel labelTituloAñadir_1;
	private JLabel labelEditorialAñadir_1;
	private JLabel labelAutorAñadir_1;
	private JLabel labelEjemplaresAñadir_1;
	private JButton botonGuardarModificar;
	private JButton botonBorrarModificar;
	private JTextField textoTituloModificar;
	private JTextField textoAutorModificar;
	private JTextField textoEditorialModificar;
	private JTextField textoEjemplaresModificar;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxModificar;
	private JList<String> listModificar;
	private DefaultListModel<String> listModelModificar;
	private JScrollPane scrollPaneModificar;
	private JScrollPane scrollPane;

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

		labelTitulo = new JLabel("Titulo: ");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTitulo.setBounds(222, 23, 177, 14);
		panelConsulta.add(labelTitulo);

		labelEditorial = new JLabel("Editorial:");
		labelEditorial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEditorial.setBounds(222, 96, 177, 14);
		panelConsulta.add(labelEditorial);

		labelAutor = new JLabel("Autor: ");
		labelAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAutor.setBounds(222, 58, 177, 14);
		panelConsulta.add(labelAutor);

		labelEjemplares = new JLabel("Ejemplares: ");
		labelEjemplares.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEjemplares.setBounds(222, 133, 177, 14);
		panelConsulta.add(labelEjemplares);

		labelEstado = new JLabel("Estado: ");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEstado.setBounds(222, 173, 177, 14);
		panelConsulta.add(labelEstado);

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setEnabled(true);
		list.setBounds(26, 35, 99, 137);
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(22, 11, 176, 200);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		panelConsulta.add(scrollPane);



		panelAñadir = new JPanel();
		panelAñadir.setBackground(Color.WHITE);
		panelPrincipal.add(panelAñadir, "panelAñadir");
		panelAñadir.setLayout(null);

		imagenLibroAñadir = new JLabel();
		imagenLibroAñadir.setIcon(new ImageIcon("src/images/default.png"));
		imagenLibroAñadir.setBounds(26, 11, 122, 142);
		panelAñadir.add(imagenLibroAñadir);

		labelTituloAñadir = new JLabel("Título: ");
		labelTituloAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTituloAñadir.setBounds(192, 6, 83, 14);
		panelAñadir.add(labelTituloAñadir);

		labelEditorialAñadir = new JLabel("Editorial:");
		labelEditorialAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEditorialAñadir.setBounds(191, 77, 83, 14);
		panelAñadir.add(labelEditorialAñadir);

		labelAutorAñadir = new JLabel("Autor: ");
		labelAutorAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAutorAñadir.setBounds(192, 42, 83, 14);
		panelAñadir.add(labelAutorAñadir);

		labelEjemplaresAñadir = new JLabel("Ejemplares: ");
		labelEjemplaresAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEjemplaresAñadir.setBounds(192, 111, 83, 14);
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

		btnLimpiar = new JButton("Limpiar");
		
		
		btnLimpiar.setBounds(236, 173, 83, 34);
		panelAñadir.add(btnLimpiar);

		tftTitulo = new JTextField();
		tftTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tftTitulo.setBounds(263, 0, 133, 29);
		panelAñadir.add(tftTitulo);
		tftTitulo.setColumns(10);

		tftAutor = new JTextField();
		tftAutor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tftAutor.setColumns(10);
		tftAutor.setBounds(262, 37, 134, 28);
		panelAñadir.add(tftAutor);

		tftEditorial = new JTextField();
		tftEditorial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tftEditorial.setColumns(10);
		tftEditorial.setBounds(263, 73, 133, 29);
		panelAñadir.add(tftEditorial);

		tftEjemplares = new JTextField();
		tftEjemplares.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tftEjemplares.setColumns(10);
		tftEjemplares.setBounds(298, 105, 96, 28);
		panelAñadir.add(tftEjemplares);

		lblNewLabel = new JLabel("Estado: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(192, 139, 83, 14);
		panelAñadir.add(lblNewLabel);

		

		comboBox = new JComboBox();
		comboBox.setBounds(276, 140, 118, 22);
		panelAñadir.add(comboBox);

		panelModificar = new JPanel();
		panelModificar.setLayout(null);
		panelModificar.setBackground(Color.WHITE);
		panelPrincipal.add(panelModificar, "panelModificar");

		labelTituloAñadir_1 = new JLabel("T\u00EDtulo: ");
		labelTituloAñadir_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTituloAñadir_1.setBounds(205, 6, 83, 14);
		panelModificar.add(labelTituloAñadir_1);

		labelEditorialAñadir_1 = new JLabel("Editorial:");
		labelEditorialAñadir_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEditorialAñadir_1.setBounds(205, 77, 83, 14);
		panelModificar.add(labelEditorialAñadir_1);

		labelAutorAñadir_1 = new JLabel("Autor: ");
		labelAutorAñadir_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAutorAñadir_1.setBounds(205, 42, 83, 14);
		panelModificar.add(labelAutorAñadir_1);

		labelEjemplaresAñadir_1 = new JLabel("Ejemplares: ");
		labelEjemplaresAñadir_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEjemplaresAñadir_1.setBounds(205, 111, 83, 14);
		panelModificar.add(labelEjemplaresAñadir_1);

		botonGuardarModificar = new JButton("Guardar");
		botonGuardarModificar.setBounds(325, 173, 89, 34);
		panelModificar.add(botonGuardarModificar);

		botonBorrarModificar = new JButton("Borrar Libro");
		botonBorrarModificar.setBounds(208, 173, 111, 34);
		panelModificar.add(botonBorrarModificar);

		textoTituloModificar = new JTextField();
		textoTituloModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoTituloModificar.setColumns(10);
		textoTituloModificar.setBounds(263, 0, 133, 28);
		panelModificar.add(textoTituloModificar);

		textoAutorModificar = new JTextField();
		textoAutorModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoAutorModificar.setColumns(10);
		textoAutorModificar.setBounds(262, 37, 134, 28);
		panelModificar.add(textoAutorModificar);

		textoEditorialModificar = new JTextField();
		textoEditorialModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoEditorialModificar.setColumns(10);
		textoEditorialModificar.setBounds(263, 73, 133, 29);
		panelModificar.add(textoEditorialModificar);

		textoEjemplaresModificar = new JTextField();
		textoEjemplaresModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoEjemplaresModificar.setColumns(10);
		textoEjemplaresModificar.setBounds(298, 105, 96, 28);
		panelModificar.add(textoEjemplaresModificar);

		lblNewLabel_1 = new JLabel("Estado: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(205, 142, 83, 14);
		panelModificar.add(lblNewLabel_1);

		comboBoxModificar = new JComboBox(new Object[] {});
		comboBoxModificar.setBounds(276, 140, 118, 22);
		panelModificar.add(comboBoxModificar);
		


		

		listModelModificar = new DefaultListModel<>();
		listModificar = new JList<>(listModelModificar);
		listModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listModificar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModificar.setEnabled(true);
		listModificar.setBounds(22, 35, 99, 137);
		scrollPaneModificar = new JScrollPane(listModificar);
		scrollPaneModificar.setBounds(22, 11, 176, 200);
		scrollPaneModificar.setPreferredSize(new Dimension(200, 200));
		panelModificar.add(scrollPaneModificar);


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

	public void setImagenLibroAñadir(JLabel imagenLibroAñadir) {
		this.imagenLibroAñadir = imagenLibroAñadir;
	}

	public JButton getBotonGuardarModificar() {
		return botonGuardarModificar;
	}

	public void setBotonGuardarModificar(JButton botonGuardarModificar) {
		this.botonGuardarModificar = botonGuardarModificar;
	}

	public JButton getBotonBorrarModificar() {
		return botonBorrarModificar;
	}

	public void setBotonBorrarModificar(JButton botonBorrarModificar) {
		this.botonBorrarModificar = botonBorrarModificar;
	}

	public JScrollPane getScrollPaneModificar() {
		return scrollPaneModificar;
	}

	public void setScrollPaneModificar(JScrollPane scrollPaneModificar) {
		this.scrollPaneModificar = scrollPaneModificar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTextField getTextoTituloModificar() {
		return textoTituloModificar;
	}

	public void setTextoTituloModificar(JTextField textoTituloModificar) {
		this.textoTituloModificar = textoTituloModificar;
	}

	public JTextField getTextoAutorModificar() {
		return textoAutorModificar;
	}

	public void setTextoAutorModificar(JTextField textoAutorModificar) {
		this.textoAutorModificar = textoAutorModificar;
	}

	public JTextField getTextoEditorialModificar() {
		return textoEditorialModificar;
	}

	public void setTextoEditorialModificar(JTextField textoEditorialModificar) {
		this.textoEditorialModificar = textoEditorialModificar;
	}

	public JTextField getTextoEjemplaresModificar() {
		return textoEjemplaresModificar;
	}

	public void setTextoEjemplaresModificar(JTextField textoEjemplaresModificar) {
		this.textoEjemplaresModificar = textoEjemplaresModificar;
	}


	

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JComboBox getComboBoxModificar() {
		return comboBoxModificar;
	}

	public void setComboBoxModificar(JComboBox comboBoxModificar) {
		this.comboBoxModificar = comboBoxModificar;
	}

	public JList getListModificar() {
		return listModificar;
	}

	public void setListModificar(JList listModificar) {
		this.listModificar = listModificar;
	}

	public DefaultListModel<String> getListModelModificar() {
		return listModelModificar;
	}

	public void setListModelModificar(DefaultListModel<String> listModelModificar) {
		this.listModelModificar = listModelModificar;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
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
