import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    public JPanel loginpanel;
    private JComboBox comboBoxlogin;
    private JTextField usertext;
    private JPasswordField passwordtext;
    private JButton ingressarboton;
    private JLabel Userl;
    private JLabel contrasenal;
    private JLabel modol;

    public login() {
        comboBoxlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la opción seleccionada
                String selectedOption = (String) comboBoxlogin.getSelectedItem();

                // Abrir la ventana correspondiente
                if (selectedOption.equals("Cajero")) {
                    Userl.setText("Cajero: ");
                } else if (selectedOption.equals("Administrativo")) {
                    Userl.setText("Admistrador: ");
                }
            }
        });
    }
}
