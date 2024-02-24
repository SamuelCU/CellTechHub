import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class administrador {
    protected JPanel administrador;
    private JTextField cedula1F;
    private JTable cajeroT;
    private JButton agregarButton;
    private JRadioButton cajeroRadioButton;
    private JRadioButton historialRadioButton;
    private JRadioButton productosRadioButton;
    private JToolBar barramenu;
    private JRadioButton salirRadioButton;
    private JButton buscarButton;
    private JLabel admintrativotext;

    private DefaultTableModel tableModel;

    public administrador() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Esta funcion le permitira agregar un nuevo cajero o producto al administrador

                String selectedOption1 = (String) cajeroRadioButton.getText();
                String selectedOption2 = (String) historialRadioButton.getText();
                String selectedOption3 = (String) productosRadioButton.getText();
                String agregarselect = (String) agregarButton.getText();

                if ((Objects.equals(selectedOption1,"Cajero")&Objects.equals(agregarselect,"Agregar Cajero"))
                || (Objects.equals(selectedOption2,"Historial")&Objects.equals(agregarselect,"Agregar Cajero"))
                ){
                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(agregarButton);
                    loginFrame.dispose();
                    JFrame frame2 = new JFrame("Nuevo Cajero");
                    frame2.setContentPane(new nuevocajero().nuevocajeropanel);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(550, 600);
                    frame2.setLocationRelativeTo(null);
                    //frame2.setUndecorated(true);
                    frame2.setVisible(true);
                }else{
                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(agregarButton);
                    loginFrame.dispose();
                    JFrame frame2 = new JFrame("Producto");
                    frame2.setContentPane(new nuevoproducto().nuevoproductopanel);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(550, 600);
                    frame2.setLocationRelativeTo(null);
                    //frame2.setUndecorated(true);
                    frame2.setVisible(true);
                }


            }
        });

        cajeroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(cajeroRadioButton);
                loginFrame.dispose();
                JFrame frame2 = new JFrame("Cajero");
                frame2.setContentPane(new administrador().administrador);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(550,300);
                frame2.setLocationRelativeTo(null);
                //frame2.setUndecorated(true);
                frame2.setVisible(true);*/
                // Obtener la opción seleccionada
                String selectedOption = (String) cajeroRadioButton.getText();

                // Abrir la ventana correspondiente
                if (selectedOption.equals("Cajero")) {
                    admintrativotext.setText("Cedula ");
                    agregarButton.setText("Agregar Cajero");
                    // Limpiar el modelo (y la tabla)
                    tableModel.setRowCount(0); // Establecer el número de filas a cero
                    // Opcionalmente, también puedes limpiar las columnas
                    tableModel.setColumnCount(0); // Establecer el número de columnas a cero
                    cedula1F.setText("");
                }
            }
        });
        historialRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mostrare todos los Cajeros con detalles de venta y el total de venta.
                String sql = "SELECT * FROM empleados";
                // Crear una sentencia
                Connection conexion = null;
                try {
                    conexion = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf");
                    Statement sentencia = conexion.createStatement();

                    // Ejecutar la consulta y obtener el resultado
                    ResultSet resultado = sentencia.executeQuery(sql);

                    System.out.println("Usuario encontrado");
                    // tabla tabler
                    String[] columnNames = {"Id", "Nombre", "contraseña", "tipo","Ventas"};
                    tableModel = new DefaultTableModel(columnNames, 0);
                    cajeroT.setModel(tableModel);

                    // Agregar una fila por defecto a la tabla tabler
                    Object[] defaultRow = {"Id", "Nombre", "contraseña", "Tipo", "Ventas"};
                    tableModel.addRow(defaultRow);

                    while (resultado.next()) {
                        // Acceder a los valores de cada columna por su nombre o índice
                        int id1 = resultado.getInt("id_empleado");
                        String nombre1 = resultado.getString("nombre");
                        String contrasenia1=resultado.getString("contrasenia");
                        String tipo1=resultado.getString("tipo");
                        Object[] rowData = {id1, nombre1, contrasenia1, tipo1};
                        tableModel.addRow(rowData);
                    }
                    // Agregar la fila por defecto al final
                    Object[] DefaultRow= {"Total Ventas", "","","","479652"};
                    tableModel.addRow(DefaultRow);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String selectedOption = (String) historialRadioButton.getText();

                // Abrir la ventana correspondiente
                if (selectedOption.equals("Historial")) {
                    admintrativotext.setText("Cedula ");
                    agregarButton.setText("Agregar Cajero");

                }
            }
        });
        salirRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame[] frames = Frame.getFrames();
                // Cerrar cada frame
                for (Frame frame : frames) {
                    frame.dispose();
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
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
                                String[] columnNames = {"Id", "Nombre", "contraseña", "tipo","Ventas"};
                                tableModel = new DefaultTableModel(columnNames, 0);
                                cajeroT.setModel(tableModel);

                                // Agregar una fila por defecto a la tabla tabler
                                Object[] defaultRow = {"Id", "Nombre", "contraseña", "Tipo", "Ventas"};
                                tableModel.addRow(defaultRow);

                                while (resultado.next()) {
                                    // Acceder a los valores de cada columna por su nombre o índice
                                    int id1 = resultado.getInt("id_empleado");
                                    String nombre1 = resultado.getString("nombre");
                                    String contrasenia1=resultado.getString("contrasenia");
                                    String tipo1=resultado.getString("tipo");
                                    if (Objects.equals(id1,Integer.parseInt(cedula1F.getText()))) {
                                        Object[] rowData = {id1, nombre1, contrasenia1, tipo1};
                                        tableModel.addRow(rowData);
                                    }
                                }
                            }else {
                                JOptionPane optionPane = new JOptionPane("Cajero no encontrado", JOptionPane.ERROR_MESSAGE);
                                // Mostrar el cuadro de diálogo
                                JDialog dialog = optionPane.createDialog("Error");
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                // Limpiar el modelo (y la tabla)
                                tableModel.setRowCount(0); // Establecer el número de filas a cero
                                // Opcionalmente, también puedes limpiar las columnas
                                tableModel.setColumnCount(0); // Establecer el número de columnas a cero
                                cedula1F.setText("");
                            }
                        }
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        productosRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) productosRadioButton.getText();

                // Abrir la ventana correspondiente
                if (selectedOption.equals("Productos")) {
                    admintrativotext.setText("Id o nombre del Producto");
                    agregarButton.setText("Agregar Producto");
                    // Limpiar el modelo (y la tabla)
                    tableModel.setRowCount(0); // Establecer el número de filas a cero
                    // Opcionalmente, también puedes limpiar las columnas
                    tableModel.setColumnCount(0); // Establecer el número de columnas a cero
                    cedula1F.setText("");
                }
            }
        });
    }
}
