import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class administrador {
    protected JPanel administrador;
    private JTextField cedula1F;
    private JTable cajeroT;
    private JButton nextButton;
    private JRadioButton cajeroRadioButton;
    private JRadioButton historialRadioButton;
    private JRadioButton productosRadioButton;
    private JToolBar barramenu;
    private JRadioButton salirRadioButton;

    public administrador() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la cédula ingresada
                String cedula = cedula1F.getText();
                String query = "SELECT id_empleado FROM empleados WHERE id_empleado = ?";
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://utrknxklzvib6amk:KkyQew23qotJ6GAkmksf@bqjaf6disbf0cayzptja-mysql.services.clever-cloud.com:3306/bqjaf6disbf0cayzptja", "utrknxklzvib6amk", "KkyQew23qotJ6GAkmksf")){
                    try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                        preparedStatement.setString(1,cedula);
                        try(ResultSet resultSet = preparedStatement.executeQuery()){
                            if(resultSet.next()){
                                System.out.println("Usuario encontrado");
                            }else{
                                System.out.println("Usuario no encontrado");
                                cedula1F.setText("");
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
