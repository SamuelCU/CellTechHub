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
                } else if (selectedOption.equals("Administrativo")) {
                    Userl.setText("Admistrador: ");
                }
            }
        });
        ingressarboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String selectedOption = (String) comboBoxlogin.getSelectedItem();
                String admi ="Daniel";
                String cajero="Kevin";
                String contraa="1234";
                String contrac="1001";
                try {
                    if (Objects.equals(usertext.getText(),admi) & Objects.equals(passwordtext.getText(),contraa) & Objects.equals(selectedOption,"Administrativo")) {
                        JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingressarboton);
                        loginFrame.dispose();
                        JFrame frame2 = new JFrame("Administrativo");
                        frame2.setContentPane(new registro().registropanel);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.setSize(550, 600);
                        frame2.setLocationRelativeTo(null);
                        frame2.setUndecorated(true);
                        frame2.setVisible(true);
                    } else if (Objects.equals(usertext.getText(),cajero) & Objects.equals(passwordtext.getText(),contrac) & Objects.equals(selectedOption,"Cajero")) {
                        JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingressarboton);
                        loginFrame.dispose();
                        JFrame frame2 = new JFrame("Cajero");
                        frame2.setContentPane(new venta().ventapanel);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.setSize(550, 600);
                        frame2.setLocationRelativeTo(null);
                        frame2.setUndecorated(true);
                        frame2.setVisible(true);
                    }else {
                        throw new Exception("Contraseña incorrecta");
                    }
                } catch (Exception E) {
                    if (Objects.equals(usertext.getText(),admi) & Objects.equals(selectedOption,"Cajero")) {
                        JOptionPane optionPane = new JOptionPane("Usted es administrador", JOptionPane.ERROR_MESSAGE);
                        // Mostrar el cuadro de diálogo
                        JDialog dialog = optionPane.createDialog("Error");
                        dialog.setResizable(false);
                        dialog.setVisible(true);
                        usertext.setText("");
                        passwordtext.setText("");

                    } else if (Objects.equals(usertext.getText(),cajero) & Objects.equals(selectedOption,"Administrativo")) {
                        JOptionPane optionPane = new JOptionPane("Usted es Cajero", JOptionPane.ERROR_MESSAGE);
                        // Mostrar el cuadro de diálogo
                        JDialog dialog = optionPane.createDialog("Error");
                        dialog.setResizable(false);
                        dialog.setVisible(true);
                        usertext.setText("");
                        passwordtext.setText("");
                    } else if (Objects.equals(selectedOption,"Administrativo")){
                        JOptionPane optionPane = new JOptionPane("Administrador o contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                        // Mostrar el cuadro de diálogo
                        JDialog dialog = optionPane.createDialog("Error");
                        dialog.setResizable(false);
                        dialog.setVisible(true);
                        usertext.setText("");
                        passwordtext.setText("");
                    } else if (Objects.equals(selectedOption,"Cajero")) {
                        JOptionPane optionPane = new JOptionPane("Cajero o contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                        // Mostrar el cuadro de diálogo
                        JDialog dialog = optionPane.createDialog("Error");
                        dialog.setResizable(false);
                        dialog.setVisible(true);
                        usertext.setText("");
                        passwordtext.setText("");
                    }
                }*/



                String user = usertext.getText();
                String query = "SELECT contrasenia FROM empleados WHERE nombre = ?";

                try(Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                    try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        preparedStatement.setString(1,user);
                        try(ResultSet resultSet = preparedStatement.executeQuery()){
                            if(resultSet.next()){
                                String passwordUser = resultSet.getString("contrasenia");
                                char[] enteredPassword = passwordtext.getPassword();
                                String enteredPasswordString = new String(enteredPassword);
                                if(passwordUser.equals(enteredPasswordString)){

                                    System.out.println("Ingreso al sistema");
                                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(ingressarboton);
                                    loginFrame.dispose();
                                    JFrame frame2 = new JFrame("Administrador");
                                    frame2.setContentPane(new administrador().administrador);
                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame2.setSize(850,550);
                                    frame2.setLocationRelativeTo(null);
                                    frame2.setVisible(true);

                                }else{
                                    System.out.println("Contraseña incorrecta");
                                    JOptionPane optionPane = new JOptionPane("Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
                                    // Mostrar el cuadro de diálogo
                                    JDialog dialog = optionPane.createDialog("Error");
                                    dialog.setResizable(false);
                                    dialog.setVisible(true);
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
                    }

                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}
