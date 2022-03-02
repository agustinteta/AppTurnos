package Clases;

import javax.swing.JOptionPane;
import java.sql.*;

public class ConexionSQL {

    private static java.sql.Connection conectar = null;
    private final String USERNAME = "root"; //Usuario
    private final String PASSWORD = "Agusstin1998!"; //Contrasena usuario root
    private final String URL = "jdbc:mysql://localhost:3306/gestiondeturnos";

    public java.sql.Connection conexion() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt=conectar.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion. " + e.getMessage());
        }
        return (java.sql.Connection) conectar;
    }

}
