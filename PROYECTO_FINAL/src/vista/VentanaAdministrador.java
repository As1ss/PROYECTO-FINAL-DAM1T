package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame {

    private JPanel contentPane;
    private JPanel panelPrincipal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private CardLayout cardLayout;

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
        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panelPrincipal.add(panel1, "Panel 1");
        panel1.setLayout(null);
        
        JList list = new JList();
        list.setBounds(93, 35, 226, 135);
        panel1.add(list);

        panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        panelPrincipal.add(panel2, "Panel 2");

        panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);
        panelPrincipal.add(panel3, "Panel 3");

        // Crear los botones de navegación
        JButton btnPanel1 = new JButton("Panel 1");
        JButton btnPanel2 = new JButton("Panel 2");
        JButton btnPanel3 = new JButton("Panel 3");

        // Agregar los botones al panel principal
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPanel1);
        panelBotones.add(btnPanel2);
        panelBotones.add(btnPanel3);
        contentPane.add(panelBotones, BorderLayout.NORTH);

        // Asignar acciones a los botones
        btnPanel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel 1");
            }
        });

        btnPanel2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel 2");
            }
        });

        btnPanel3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel 3");
            }
        });
    }
}
