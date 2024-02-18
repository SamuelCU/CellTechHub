import java.sql.*;
public class MysqlConnection {
    String server;
    String user;
    String password;

    public MysqlConnection(String server, String user, String password) {
        this.server = server;
        this.user = user;
        this.password = password;
    }

    public MysqlConnection() {
    }

    public void mysqlConnection(String server, String user, String password){
        try(Connection connection = DriverManager.getConnection(server, user, password)){
            if(connection != null){
                System.out.println("Conexion correcta");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
