import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class cajeropantalla {
    private JLabel usertext;
    private JRadioButton outButton;
    private JRadioButton returnButton;
    private JTextField cedula1F;
    private JButton buscarbutton;
    private JTable cajeroT;
    private JButton agregarbutton;
    public JPanel acajeropanel;
    private JPanel barracajeros;
    private JPanel logocell;
    private JPanel tablecajeros;
    private DefaultTableModel tableModel;

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
        buscarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Buscara el Cajero correspondiente al ingreso de su cedula

                // Obtener la cédula ingresada
                String cedula = cedula1F.getText();
                String query = "SELECT id_empleado FROM empleados WHERE id_empleado = ?";
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                    try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        preparedStatement.setString(1,cedula);
                        try(ResultSet resultSet = preparedStatement.executeQuery()){
                            if(resultSet.next()){
                                String sql = "SELECT * FROM empleados";
                                // Crear una sentencia
                                Connection conexion = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf");
                                Statement sentencia = conexion.createStatement();

                                // Ejecutar la consulta y obtener el resultado
                                ResultSet resultado = sentencia.executeQuery(sql);

                                System.out.println("Usuario encontrado");
                                // tabla tabler
                                String[] columnNames = {"Id","Nombre","tipo","Ventas"};
                                tableModel = new DefaultTableModel(columnNames, 0);
                                cajeroT.setModel(tableModel);

                                // Agregar una fila por defecto a la tabla tabler
                                Object[] defaultRow = {"Id","Nombre","Tipo", "Ventas"};
                                tableModel.addRow(defaultRow);

                                while (resultado.next()) {
                                    // Acceder a los valores de cada columna por su nombre o índice
                                    int id1 = resultado.getInt("id_empleado");
                                    String nombre1 = resultado.getString("nombre");
                                    String tipo1=resultado.getString("tipo");
                                    if (Objects.equals(id1,Integer.parseInt(cedula1F.getText()))) {
                                        Object[] rowData = {id1, nombre1, tipo1};
                                        tableModel.addRow(rowData);
                                    }
                                }
                            }else {
                                cedula1F.setText(" ");
                                JOptionPane optionPane = new JOptionPane("Cajero no encontrado", JOptionPane.ERROR_MESSAGE);
                                // Mostrar el cuadro de diálogo
                                JDialog dialog = optionPane.createDialog("Error");
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                // Limpiar el modelo (y la tabla)
                                tableModel.setRowCount(0); // Establecer el número de filas a cero
                                // Opcionalmente, también puedes limpiar las columnas
                                tableModel.setColumnCount(0); // Establecer el número de columnas a cero
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
