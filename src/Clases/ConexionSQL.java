package Clases;

import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class ConexionSQL {

    Connection conectar = null;

    public static final String URL = "jdbc:mysql://localhost:3306/gestiondeturnos";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345";

    public Connection conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion" + e.getMessage());
        }
        return conectar;
    }

}
