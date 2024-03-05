import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class venta {
    public JPanel ventapanel;
    private JRadioButton outButton;
    private JLabel usertext;
    private JRadioButton returnButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JTable table1;
    private JButton AGREGARButton;
    private JLabel imgLabel;

    public venta() {
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
                frame2.setContentPane(new cajero().cajeropanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textField1.getText();
                String[] columnNames = {"Id", "Nombre", "Precio", "Stock", "Categoría"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // Inicializar tableModel aquí

                // Agregar la fila de nombres de columna
                tableModel.addRow(columnNames);

                table1.setModel(tableModel);

                // Establecer la conexión a la base de datos
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")) {
                    // Preparar la consulta SQL con un placeholder
                    String query = "SELECT id_producto, nombre, precio, stock, id_categoria, imagen_img FROM producto WHERE id_producto = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, codigo);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            if (resultSet.next()) {
                                int id = resultSet.getInt("id_producto");
                                String nombre = resultSet.getString("nombre");
                                Float precio = resultSet.getFloat("precio");
                                int stock = resultSet.getInt("stock");
                                int categoria_id = resultSet.getInt("id_categoria");

                                // Obtener el nombre de la categoría
                                String nombreCategoria = "";
                                String sql2 = "SELECT nombre FROM categoria WHERE id_categoria = ?";
                                try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
                                    preparedStatement2.setInt(1, categoria_id);
                                    try (ResultSet resultSet2 = preparedStatement2.executeQuery()) {
                                        if (resultSet2.next()) {
                                            nombreCategoria = resultSet2.getString("nombre");
                                        }
                                    }
                                }

                                // Mostrar los datos del producto
                                System.out.println("Producto encontrado");
                                Object[] rowData = {id, nombre, precio, stock, nombreCategoria};
                                tableModel.addRow(rowData);

                                byte[] imageData = resultSet.getBytes("imagen_img");
                                if (imageData != null) {
                                    ImageIcon imageIcon = new ImageIcon(imageData); // Convertir el arreglo de bytes en un ImageIcon
                                    Image image = imageIcon.getImage(); // Obtener la imagen del ImageIcon
                                    // Escalar la imagen para ajustar el tamaño del imgLabel
                                    Image scaledImage = image.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
                                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                                    imgLabel.setIcon(scaledImageIcon); // Establecer la imagen escalada en el imgLabel
                                } else {
                                    imgLabel.setIcon(null); // Si no hay imagen, limpiar el imgLabel
                                }
                            } else {
                                textField1.setText(" ");
                                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                                // Limpiar el modelo (y la tabla)
                                tableModel.setRowCount(0); // Establecer el número de filas a cero
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }




            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCategoria = textField2.getText(); // Obtener el nombre de la categoría desde el JTextField2

                // Establecer la conexión a la base de datos
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")) {
                    // Buscar el ID de la categoría usando el nombre de la categoría
                    int categoria_id = -1; // Inicializar el ID de la categoría como -1
                    String queryCategoria = "SELECT id_categoria FROM categoria WHERE nombre = ?";
                    try (PreparedStatement preparedStatementCategoria = connection.prepareStatement(queryCategoria)) {
                        preparedStatementCategoria.setString(1, nombreCategoria);
                        try (ResultSet resultSetCategoria = preparedStatementCategoria.executeQuery()) {
                            if (resultSetCategoria.next()) {
                                categoria_id = resultSetCategoria.getInt("id_categoria");
                            }
                        }
                    }

                    // Verificar si se encontró la categoría
                    if (categoria_id != -1) {
                        String[] columnNames = {"Id", "Nombre", "Precio", "Stock", "Categoría"};
                        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // Inicializar tableModel aquí
                        table1.setModel(tableModel);

                        // Consulta para buscar los productos con la categoría correspondiente
                        String queryProductos = "SELECT id_producto, nombre, precio, stock, imagen_img FROM producto WHERE id_categoria = ?";
                        try (PreparedStatement preparedStatementProductos = connection.prepareStatement(queryProductos)) {
                            preparedStatementProductos.setInt(1, categoria_id);
                            try (ResultSet resultSetProductos = preparedStatementProductos.executeQuery()) {
                                // Agregar la fila de nombres de columna
                                tableModel.addRow(columnNames);

                                // Agregar los datos de los productos a la tabla
                                while (resultSetProductos.next()) {
                                    int id = resultSetProductos.getInt("id_producto");
                                    String nombre = resultSetProductos.getString("nombre");
                                    Float precio = resultSetProductos.getFloat("precio");
                                    int stock = resultSetProductos.getInt("stock");

                                    // Mostrar los datos del producto
                                    Object[] rowData = {id, nombre, precio, stock, nombreCategoria};
                                    tableModel.addRow(rowData);

                                    byte[] imageData = resultSetProductos.getBytes("imagen_img");
                                    if (imageData != null) {
                                        ImageIcon imageIcon = new ImageIcon(imageData); // Convertir el arreglo de bytes en un ImageIcon
                                        Image image = imageIcon.getImage(); // Obtener la imagen del ImageIcon
                                        // Escalar la imagen para ajustar el tamaño del imgLabel
                                        Image scaledImage = image.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
                                        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                                        imgLabel.setIcon(scaledImageIcon); // Establecer la imagen escalada en el imgLabel
                                    } else {
                                        imgLabel.setIcon(null); // Si no hay imagen, limpiar el imgLabel
                                    }
                                }


                            }
                        }
                    } else {
                        // Si no se encontró la categoría, mostrar un mensaje de error
                        JOptionPane.showMessageDialog(null, "Categoría no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }




            }
        });
    }
}
