package Clases;

import javax.swing.JOptionPane;
import java.sql.*;

public class ConexionSQL {

    private static java.sql.Connection conectar = null;
    private final String NOMBREBD = "gestiondeturnos"; //Nombre base de datos
    private final String USERNAME = "root"; //Usuario
    private final String PASSWORD = "1234"; //Contrasena usuario root
    private final String URL = "jdbc:mysql://localhost:3306/" + NOMBREBD + "?useUnicode=true&use" //direccion de la base de datos
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    public java.sql.Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion. " + e.getMessage());
        }
        return (java.sql.Connection) conectar;
    }

    public ResultSet getTabla(String Consulta) {
        Connection con = conexion();
        Statement st;
        ResultSet datos = null;
        try {
            st = con.createStatement();
            datos = st.executeQuery(Consulta);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;
    }

}
