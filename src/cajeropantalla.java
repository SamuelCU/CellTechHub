import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cajeropantalla {
    private JLabel usertext;
    private JRadioButton outButton;
    private JRadioButton returnButton;
    private JTextField textField1;
    private JButton buscarbutton;
    private JTable table1;
    private JButton agregarbutton;
    public JPanel acajeropanel;
    private JPanel barracajeros;
    private JPanel logocell;
    private JPanel tablecajeros;

    public cajeropantalla() {
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
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Retroceder");
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(returnButton);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Retroceder");
                frame2.setContentPane(new administrador().administrador);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        agregarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nuevo Cajero");
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(agregarbutton);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Cajero Nuevo");
                frame2.setContentPane(new nuevocajero().nuevocajeropanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
    }
}
