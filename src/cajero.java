import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cajero {
    private JRadioButton outButton;
    private JLabel usertext;
    public JPanel cajeropanel;
    private JButton clientebutton1;
    private JButton ventasbutton1;

    public cajero() {
        clientebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ingreso a Clientes");
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(clientebutton1);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Clientes");
                frame2.setContentPane(new cliente().clientepanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        ventasbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ingreso a Ventas");
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ventasbutton1);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Salir");
                frame2.setContentPane(new venta().ventapanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        outButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Salir al sistema");
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(outButton);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Salir");
                frame2.setContentPane(new login().loginpanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
    }
}
