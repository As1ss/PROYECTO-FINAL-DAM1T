package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class VentanaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPedido;
	private JButton btnDevolucion;
	private JPanel panelGeneral;
	private JLabel labelTituloPedir;
	private JLabel labelEditorialPedir;
	private JLabel labelAutorPedir;
	private JLabel labelEjemplaresPedir;
	private JLabel labelEstadoPedir;
	private JButton btnPedir;
	private JLabel labelTituloDevolver;
	private JLabel labelEditorialDevolver;
	private JLabel labelAutorDevolver;
	private JLabel labelEjemplaresDevolver;
	private JLabel labelEstadoDevolver;
	private JButton btnDevolver;
	private CardLayout cardLayout;
	private JList listPedido;
	private DefaultListModel<String> listModelPedido;
	private JScrollPane scrollPanePedido;
	private JList listDevolucion;
	private DefaultListModel<String> listModelDevolucion;

	public VentanaCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelBotones = new JPanel();
			contentPanel.add(panelBotones, BorderLayout.NORTH);
			{
				btnPedido = new JButton("Pedido");
				panelBotones.add(btnPedido);
			}
			{
				btnDevolucion = new JButton("Devolucion");
				panelBotones.add(btnDevolucion);
			}
		}
		{
			panelGeneral = new JPanel();
			contentPanel.add(panelGeneral, BorderLayout.CENTER);
			cardLayout = new CardLayout(0, 0);
			panelGeneral.setLayout(cardLayout);
			{
				JPanel panelPedido = new JPanel();
				panelPedido.setLayout(null);
				panelPedido.setBackground(Color.WHITE);
				panelGeneral.add(panelPedido, "panelPedido");
				{
					labelTituloPedir = new JLabel("Titulo: ");
					labelTituloPedir.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelTituloPedir.setBounds(237, 23, 177, 14);
					panelPedido.add(labelTituloPedir);
				}
				{
					labelEditorialPedir = new JLabel("Editorial:");
					labelEditorialPedir.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEditorialPedir.setBounds(237, 96, 177, 14);
					panelPedido.add(labelEditorialPedir);
				}
				{
					labelAutorPedir = new JLabel("Autor: ");
					labelAutorPedir.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelAutorPedir.setBounds(237, 58, 177, 14);
					panelPedido.add(labelAutorPedir);
				}
				{
					labelEjemplaresPedir = new JLabel("Ejemplares: ");
					labelEjemplaresPedir.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEjemplaresPedir.setBounds(237, 133, 177, 14);
					panelPedido.add(labelEjemplaresPedir);
				}
				{
					labelEstadoPedir = new JLabel("Estado: ");
					labelEstadoPedir.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEstadoPedir.setBounds(237, 173, 177, 14);
					panelPedido.add(labelEstadoPedir);
				}

				btnPedir = new JButton("Pedir");
				btnPedir.setBounds(78, 169, 66, 23);
				panelPedido.add(btnPedir);
				{
					listModelPedido = new DefaultListModel<>();
					listPedido = new JList(listModelPedido);
					listPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
					listPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listPedido.setEnabled(true);
					listPedido.setBounds(26, 35, 99, 137);
					scrollPanePedido = new JScrollPane(listPedido);
					scrollPanePedido.setBounds(22, 11, 176, 150);
					scrollPanePedido.setPreferredSize(new Dimension(200, 150));
					panelPedido.add(scrollPanePedido);
				}

			}
			{
				JPanel panelDevolucion = new JPanel();
				panelDevolucion.setLayout(null);
				panelDevolucion.setBackground(Color.WHITE);
				panelGeneral.add(panelDevolucion, "panelDevolucion");
				{
					btnDevolver = new JButton("Devolver");
					btnDevolver.setBounds(60, 168, 93, 23);
					panelDevolucion.add(btnDevolver);
				}
				{
					labelTituloDevolver = new JLabel("Titulo: ");
					labelTituloDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelTituloDevolver.setBounds(237, 22, 177, 14);
					panelDevolucion.add(labelTituloDevolver);
				}
				{
					labelEditorialDevolver = new JLabel("Editorial:");
					labelEditorialDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEditorialDevolver.setBounds(237, 95, 177, 14);
					panelDevolucion.add(labelEditorialDevolver);
				}
				{
					labelAutorDevolver = new JLabel("Autor: ");
					labelAutorDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelAutorDevolver.setBounds(237, 57, 177, 14);
					panelDevolucion.add(labelAutorDevolver);
				}
				{
					labelEjemplaresDevolver = new JLabel("Ejemplares: ");
					labelEjemplaresDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEjemplaresDevolver.setBounds(237, 132, 177, 14);
					panelDevolucion.add(labelEjemplaresDevolver);
				}
				{
					labelEstadoDevolver = new JLabel("Estado: ");
					labelEstadoDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
					labelEstadoDevolver.setBounds(237, 172, 177, 14);
					panelDevolucion.add(labelEstadoDevolver);
				}
				{
					
					listModelDevolucion = new DefaultListModel<>();
					listDevolucion = new JList(listModelDevolucion);
					listDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 15));
					listDevolucion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listDevolucion.setEnabled(true);
					listDevolucion.setBounds(26, 35, 99, 137);
					JScrollPane scrollPaneDevolucion = new JScrollPane(listDevolucion);
					scrollPaneDevolucion.setBounds(22, 11, 176, 150);
					scrollPaneDevolucion.setPreferredSize(new Dimension(200, 150));
					panelDevolucion.add(scrollPaneDevolucion);
				}
			}
		}
	}

	public JList getListDevolucion() {
		return listDevolucion;
	}

	public void setListDevolucion(JList listDevolucion) {
		this.listDevolucion = listDevolucion;
	}

	public DefaultListModel<String> getListModelDevolucion() {
		return listModelDevolucion;
	}

	public void setListModelDevolucion(DefaultListModel<String> listModelDevolucion) {
		this.listModelDevolucion = listModelDevolucion;
	}

	public JList getListPedido() {
		return listPedido;
	}

	public void setListPedido(JList listPedido) {
		this.listPedido = listPedido;
	}

	public DefaultListModel<String> getListModelPedido() {
		return listModelPedido;
	}

	public void setListModelPedido(DefaultListModel<String> listModelPedido) {
		this.listModelPedido = listModelPedido;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JButton getBtnPedido() {
		return btnPedido;
	}

	public JButton getBtnDevolucion() {
		return btnDevolucion;
	}

	public JPanel getPanelGeneral() {
		return panelGeneral;
	}

	public JLabel getLabelTituloPedir() {
		return labelTituloPedir;
	}

	public JLabel getLabelEditorialPedir() {
		return labelEditorialPedir;
	}

	public JLabel getLabelAutorPedir() {
		return labelAutorPedir;
	}

	public JLabel getLabelEjemplaresPedir() {
		return labelEjemplaresPedir;
	}

	public JLabel getLabelEstadoPedir() {
		return labelEstadoPedir;
	}

	public JButton getBtnPedir() {
		return btnPedir;
	}


	public JLabel getLabelTituloDevolver() {
		return labelTituloDevolver;
	}

	public JLabel getLabelEditorialDevolver() {
		return labelEditorialDevolver;
	}

	public JLabel getLabelAutorDevolver() {
		return labelAutorDevolver;
	}

	public JLabel getLabelEjemplaresDevolver() {
		return labelEjemplaresDevolver;
	}

	public JLabel getLabelEstadoDevolver() {
		return labelEstadoDevolver;
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}
}
