import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;


public class nuevoproducto {
    public JPanel nuevoproductopanel;
    private JRadioButton outButton;
    private JLabel usertext;
    private JRadioButton returnButton;
    private JButton AGREGARPRODUCTOButton;
    private JTextField textCodigo;
    private JTextField textPrecio;
    private JLabel imgLabel;
    private JButton AGREGARIMAGENButton;
    private JTextField textNombre;
    private JTextField textCategoria;
    private JTextField textStock;


    public nuevoproducto() {
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
                frame2.setContentPane(new productos().productospanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(850,550);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        AGREGARIMAGENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Leer la imagen como un arreglo de bytes
                        FileInputStream fis = new FileInputStream(selectedFile);
                        byte[] imageData = fis.readAllBytes();
                        fis.close();

                        // Mostrar la imagen en el JLabel
                        ImageIcon imageIcon = new ImageIcon(imageData); // Convertir el arreglo de bytes en un ImageIcon
                        // Escalar la imagen para ajustar el tamaño del JLabel
                        Image image = imageIcon.getImage();
                        Image scaledImage = image.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                        imgLabel.setIcon(scaledImageIcon);

                        /*// Mostrar un diálogo de confirmación
                        int option = JOptionPane.showConfirmDialog(null, "¿Desea guardar esta imagen?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            // Guardar la imagen en la base de datos
                            //guardarImagen(imageData);
                            JOptionPane.showMessageDialog(null, "Su datos y la Imagen se Guardaron correctamente en la base de datos");
                        } else {
                            JOptionPane.showMessageDialog(null, "Imagen no guardada");
                        }*/
                    } catch (IOException ex /*| SQLException ex*/) {
                        ex.printStackTrace();
                        //JOptionPane.showMessageDialog(null, "Error al subir la imagen: " + ex.getMessage());
                    }
                }


            }
        });


        AGREGARPRODUCTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")) {
                    // Insertar datos en la tabla categoria
                    String categoria = textCategoria.getText();
                    String insertCategoriaQuery = "INSERT INTO categoria (nombre) VALUES (?)";
                    try (PreparedStatement insertCategoriaStatement = connection.prepareStatement(insertCategoriaQuery, Statement.RETURN_GENERATED_KEYS)) {
                        insertCategoriaStatement.setString(1, categoria);
                        int affectedRows = insertCategoriaStatement.executeUpdate();
                        if (affectedRows == 0) {
                            throw new SQLException("Error al insertar datos en la tabla categoria.");
                        }
                        try (ResultSet generatedKeys = insertCategoriaStatement.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                int idCategoria = generatedKeys.getInt(1); // Obtener el id_categoria generado
                                // Insertar datos en la tabla producto
                                String nombreProducto = textNombre.getText();
                                int codigoProducto = Integer.parseInt(textCodigo.getText());
                                float precioProducto = Float.parseFloat(textPrecio.getText());
                                int stockProducto = Integer.parseInt(textStock.getText());
                                byte[] imagenProducto = obtenerBytesImagen(imgLabel);

                                String insertProductoQuery = "INSERT INTO producto (id_categoria, id_producto, nombre, precio, stock, imagen_img) VALUES (?, ?, ?, ?, ?, ?)";
                                try (PreparedStatement insertProductoStatement = connection.prepareStatement(insertProductoQuery)) {
                                    insertProductoStatement.setInt(1, idCategoria);
                                    insertProductoStatement.setInt(2, codigoProducto);
                                    insertProductoStatement.setString(3, nombreProducto);
                                    insertProductoStatement.setFloat(4, precioProducto);
                                    insertProductoStatement.setInt(5, stockProducto);
                                    insertProductoStatement.setBytes(6, imagenProducto);

                                    insertProductoStatement.executeUpdate();
                                }
                            } else {
                                throw new SQLException("Error al obtener el id_categoria generado.");
                            }
                        }
                    }
                } catch (SQLException | NumberFormatException | IOException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción adecuadamente
                }

            }


        });


    }

    public byte[] obtenerBytesImagen(JLabel label) throws IOException {
        // Obtener la imagen del JLabel
        Icon icon = label.getIcon();
        if (icon instanceof ImageIcon) {
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.createGraphics();
            // Dibujar la imagen en el BufferedImage
            icon.paintIcon(label, graphics, 0, 0);
            graphics.dispose();

            // Convertir la imagen a un arreglo de bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            byte[] imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();

            return imageData;
        } else {
            throw new IOException("El icono del JLabel no es una instancia de ImageIcon.");
        }
    }

}


