import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class productos {
    private JRadioButton outButton;
    private JLabel usertext;
    private JRadioButton returnButton;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JButton button2;
    private JTable table1;
    private JButton AGREGARButton;
    public JPanel productospanel;
    private JButton AGREGARIMGButton;

    public productos() {
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
    }
}
