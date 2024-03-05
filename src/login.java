import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
                } else if (selectedOption.equals("Administrador")) {
                    Userl.setText("Admistrador: ");
                }
            }
        });
        ingressarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                String user = usertext.getText();
                String query = "SELECT contrasenia,tipo FROM empleados WHERE nombre = ?";
                String selectedOption = (String) comboBoxlogin.getSelectedItem();

                try(Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                    try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        preparedStatement.setString(1,user);
                        try(ResultSet resultSet = preparedStatement.executeQuery()){
                            if(resultSet.next()){
                                String passwordUser = resultSet.getString("contrasenia");
                                String tipo = resultSet.getString("tipo");
                                System.out.println(tipo);
                                char[] enteredPassword = passwordtext.getPassword();
                                String enteredPasswordString = new String(enteredPassword);
                                if(passwordUser.equals(enteredPasswordString) & tipo.equals(selectedOption)){
                                    if (tipo.equals("Administrador")) {
                                        System.out.println("Ingreso al sistema");
                                        JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingressarboton);
                                        loginFrame.dispose();
                                        JFrame frame2 = new JFrame("Administrador");
                                        frame2.setContentPane(new administrador().administrador);
                                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame2.setSize(850, 550);
                                        frame2.setLocationRelativeTo(null);
                                        frame2.setVisible(true);
                                    }else {
                                        JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingressarboton);
                                        loginFrame.dispose();
                                        JFrame frame2 = new JFrame("Cajero");
                                        frame2.setContentPane(new cajero().cajeropanel);
                                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame2.setSize(850, 550);
                                        frame2.setLocationRelativeTo(null);
                                        frame2.setVisible(true);
                                    }
                                }else{
                                    System.out.println(tipo);
                                    System.out.println(passwordUser);
                                    System.out.println(enteredPassword);
                                    if (passwordUser.equals(enteredPasswordString) & selectedOption.equals("Administrador")){
                                        JOptionPane optionPane = new JOptionPane("Usted es Cajero", JOptionPane.ERROR_MESSAGE);
                                        // Mostrar el cuadro de diálogo
                                        JDialog dialog = optionPane.createDialog("Error");
                                        dialog.setResizable(false);
                                        dialog.setVisible(true);
                                        usertext.setText("");
                                        passwordtext.setText("");
                                    }else if(passwordUser.equals(enteredPasswordString) & selectedOption.equals("Cajero")) {
                                        JOptionPane optionPane = new JOptionPane("Usted es Administrador", JOptionPane.ERROR_MESSAGE);
                                        // Mostrar el cuadro de diálogo
                                        JDialog dialog = optionPane.createDialog("Error");
                                        dialog.setResizable(false);
                                        dialog.setVisible(true);
                                    }else {
                                        System.out.println("Contraseña incorrecta");
                                        JOptionPane optionPane = new JOptionPane("Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                                        // Mostrar el cuadro de diálogo
                                        JDialog dialog = optionPane.createDialog("Error");
                                        dialog.setResizable(false);
                                        dialog.setVisible(true);
                                    }
                                    usertext.setText("");
                                    passwordtext.setText("");
                                }
                            }else{
                                System.out.println("Usuario no encontrado");
                                JOptionPane optionPane = new JOptionPane("Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
                                // Mostrar el cuadro de diálogo
                                JDialog dialog = optionPane.createDialog("Error");
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                usertext.setText("");
                                passwordtext.setText("");
                            }
                        }
                        connection.close();
                    }


                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}
