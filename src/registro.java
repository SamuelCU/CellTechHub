import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class registro {
    public JPanel registropanel;
    private JRadioButton outButton;
    private JLabel usertext;
    private JRadioButton returnButton;
    private JTextField nombretext;
    private JTextField cedulatext;
    private JButton AGREGARButton;
    private JTextField cnombretext;
    private JTextField dirreciontext;
    private JTextField telefonotext;
    private JTextField emailtext;

    public registro() {
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
                frame2.setContentPane(new cliente().clientepanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idn= Integer.parseInt(cedulatext.getText());
                String nombre = nombretext.getText();
                String cnombre = cnombretext.getText();
                String email= emailtext.getText();
                String telefono= telefonotext.getText();
                String dir =dirreciontext.getText();
                if(Objects.equals(nombretext.getText(),cnombretext.getText())
                ){
                    try(Connection connection= DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                        String sql="INSERT INTO cliente(id_cliente,nombre,email,telefono,direccion)values(?,?,?,?,?)";
                        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                            preparedStatement.setInt(1,idn);
                            preparedStatement.setString(2,nombre);
                            preparedStatement.setString(3,email);
                            preparedStatement.setString(4,telefono);
                            preparedStatement.setString(5,dir);
                            int filasAfectadas=preparedStatement.executeUpdate();
                            if(filasAfectadas>0){
                                System.out.println("Insercion exitosa");
                                nombretext.setText("");
                                cedulatext.setText("");
                                cnombretext.setText("");
                                emailtext.setText("");
                                telefonotext.setText("");
                                dirreciontext.setText("");
                            }else {
                                System.out.println("No se pudo insertar");
                            }
                        }catch (SQLException ex){
                            ex.printStackTrace();
                        }
                    }catch (SQLException ex){
                        ex.printStackTrace();
                    }
                }else {
                    JOptionPane optionPane = new JOptionPane("No coincioden las credenciales", JOptionPane.ERROR_MESSAGE);
                    // Mostrar el cuadro de diálogo
                    JDialog dialog = optionPane.createDialog("Error");
                    dialog.setResizable(false);
                    dialog.setVisible(true);
                    nombretext.setText("");
                    cnombretext.setText("");
                }
            }
        });
    }
}
