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
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

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
	private JLabel imagenLibroDevolver;
	private JLabel labelTituloDevolver;
	private JLabel labelEditorialDevolver;
	private JLabel labelAutorDevolver;
	private JLabel labelEjemplaresDevolver;
	private JLabel labelEstadoDevolver;
	private JButton btnDevolver;
	private CardLayout cardLayout;

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
					labelTituloPedir.setBounds(237, 23, 177, 14);
					panelPedido.add(labelTituloPedir);
				}
				{
					labelEditorialPedir = new JLabel("Editorial:");
					labelEditorialPedir.setBounds(237, 96, 177, 14);
					panelPedido.add(labelEditorialPedir);
				}
				{
					labelAutorPedir = new JLabel("Autor: ");
					labelAutorPedir.setBounds(237, 58, 177, 14);
					panelPedido.add(labelAutorPedir);
				}
				{
					labelEjemplaresPedir = new JLabel("Ejemplares: ");
					labelEjemplaresPedir.setBounds(237, 133, 177, 14);
					panelPedido.add(labelEjemplaresPedir);
				}
				{
					labelEstadoPedir = new JLabel("Estado: ");
					labelEstadoPedir.setBounds(237, 173, 177, 14);
					panelPedido.add(labelEstadoPedir);
				}

				btnPedir = new JButton("Pedir");
				btnPedir.setBounds(78, 169, 66, 23);
				panelPedido.add(btnPedir);
				DefaultListModel<String> listModelPedido = new DefaultListModel<>();
				JList<String> listPedido = new JList<>(listModelPedido);
				listPedido.setBounds(33, 22, 146, 125);
				JScrollPane scrollPanePedido = new JScrollPane(listPedido);
				panelPedido.add(listPedido);
			}
			{
				JPanel panelDevolucion = new JPanel();
				panelDevolucion.setLayout(null);
				panelDevolucion.setBackground(Color.WHITE);
				panelGeneral.add(panelDevolucion, "panelDevolucion");
				{
					imagenLibroDevolver = new JLabel();
					imagenLibroDevolver.setBounds(31, 11, 122, 142);
					panelDevolucion.add(imagenLibroDevolver);
				}
				{
					btnDevolver = new JButton("Devolver");
					btnDevolver.setBounds(57, 164, 82, 23);
					panelDevolucion.add(btnDevolver);
				}
				{
					labelTituloDevolver = new JLabel("Ttulo: ");
					labelTituloDevolver.setBounds(222, 23, 177, 14);
					panelDevolucion.add(labelTituloDevolver);
				}
				{
					labelEditorialDevolver = new JLabel("Editorial:");
					labelEditorialDevolver.setBounds(222, 96, 177, 14);
					panelDevolucion.add(labelEditorialDevolver);
				}
				{
					labelAutorDevolver = new JLabel("Autor: ");
					labelAutorDevolver.setBounds(222, 58, 177, 14);
					panelDevolucion.add(labelAutorDevolver);
				}
				{
					labelEjemplaresDevolver = new JLabel("Ejemplares: ");
					labelEjemplaresDevolver.setBounds(222, 133, 177, 14);
					panelDevolucion.add(labelEjemplaresDevolver);
				}
				{
					labelEstadoDevolver = new JLabel("Estado: ");
					labelEstadoDevolver.setBounds(222, 173, 177, 14);
					panelDevolucion.add(labelEstadoDevolver);
				}
			}
		}
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

	public JLabel getImagenLibroDevolver() {
		return imagenLibroDevolver;
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
