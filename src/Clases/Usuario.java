package Clases;

import Clases.ConexionSQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class Usuario {

    //atributos de la clase usuario
    private String nombre;
    private String contrasena;
    private int dni;

    //variables SQL
    ConexionSQL cc = new ConexionSQL();
    java.sql.Connection con = (Connection) cc.conexion();

    //CONSTRUCTORES PARA LA CLASE USUARIOS.
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String contrasena, int dni) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.dni = dni;
    }

    //FUNCIONES GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getPassword() {
        return contrasena;
    }

    //FUNCIONES SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setPassword(String password) {
        this.contrasena = password;
    }

    //FUNCION PARA OBTENER EL ID DE UN USUARIO
    public int getIdUsuario(String nombreUsuario) {
        int id = -1;
        try {
            String SQL = "SELECT idusuario FROM usuarios WHERE nombre='" + nombreUsuario + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            id = rs.getInt("idusuario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario no registrado." + e.getMessage());
        }
        return id;
    }

    //FUNCION PARA VALIDAR USUARIO
    public boolean validarUsuario() {
        try {
            String SQL = "SELECT * FROM usuarios WHERE nombre='" + this.nombre + "' and contrasena='" + this.contrasena + "' ";
            //Objeto para creear la conexion.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no registrado. Por favor registrese o reingrese los datos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario no registrado." + e.getMessage());
        }
        return false;
    }

    //
    public boolean agregarUsuario() {

        String SQL = "INSERT INTO usuarios (dni, nombre, contrasena) VALUES (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst = con.prepareStatement(SQL);
            pst.setInt(1, this.dni);
            pst.setString(2, this.nombre);
            pst.setString(3, this.contrasena);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.");

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro" + e.getMessage());

        }
        return false;
    }

}
