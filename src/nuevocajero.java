import javax.swing.*;

public class nuevocajero {
    public JPanel nuevocajeropanel;
    private JRadioButton radioButton1;
    private JLabel usertext;
    private JRadioButton radioButton2;
    private JTextField textField1;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton AGREGARButton;

    public nuevocajero() {
        /*regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Administrador");
                frame2.setContentPane(new administrador().administrador);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(550, 300);
                frame2.setLocationRelativeTo(null);
                // frame2.setUndecorated(true);
                frame2.setVisible(true);
                JFrame saldoFrame = (JFrame) SwingUtilities.getWindowAncestor(regresarButton);
                saldoFrame.dispose();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idn= Integer.parseInt(cedulatext.getText());
                String nombren= nombretext.getText();
                String contrasenian=contraseniatext.getText();
                if(Objects.equals(cedulatext.getText(),ccedulatext.getText())&
                    Objects.equals(nombretext.getText(),cnombretext.getText())&
                        Objects.equals(contraseniatext.getText(),ccontrasenoatext.getText())
                ){
                    try(Connection connection= DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                        String sql="INSERT INTO empleados(id_empleado,nombre,contrasenia,tipo)values(?,?,?,?)";
                        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                            preparedStatement.setInt(1,idn);
                            preparedStatement.setString(2,nombren);
                            preparedStatement.setString(3,contrasenian);
                            preparedStatement.setString(4,"Cajero");
                            int filasAfectadas=preparedStatement.executeUpdate();
                            if(filasAfectadas>0){
                                System.out.println("Insercion exitosa");
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
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame[] frames = Frame.getFrames();
                // Cerrar cada frame
                for (Frame frame : frames) {
                    frame.dispose();
                }
            }
        });*/
    }
}
