package Clases;

import Clases.ConexionSQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class Usuario {

    //Atributos de la clase usuario
    private String nombre;
    private String contrasena;
    private int dni;
    private String email;

    //Variables SQL
    ConexionSQL cc = new ConexionSQL();
    java.sql.Connection con = (Connection) cc.conexion();

    //CONSTRUCTORES PARA LA CLASE USUARIOS.
    public Usuario(String dni, String contrasena) {
        this.dni = Integer.parseInt(dni);
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String contrasena, int dni, String email) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.dni = dni;
        this.email = email;
    }

    //METODOS GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getPassword() {
        return contrasena;
    }
    
    public String getEmail(){
        return email;
    }

    //METODOS SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setPassword(String password) {
        this.contrasena = password;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    //METODO PARA OBTENER EL ID DE UN USUARIO
    public int getIdUsuario(int dni) {
        int id = -1;
        try {
            String SQL = "SELECT idusuario FROM usuarios WHERE dni='" + dni + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            id = rs.getInt("idusuario");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario no registrado." + e.getMessage());
        }
        return id;
    }

    //METODO PARA VALIDAR USUARIO
    public boolean validarUsuario() {
        try {
            String SQL = "SELECT * FROM usuarios WHERE dni='" + this.dni + "' and contrasena='" + this.contrasena + "' ";
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

    //METODO PARA AGREGAR USUARIO
    public boolean agregarUsuario() {

        String SQL = "INSERT INTO usuarios (dni, nombre, contrasena, email) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);

            pst = con.prepareStatement(SQL);
            pst.setInt(1, this.dni);
            pst.setString(2, this.nombre);
            pst.setString(3, this.contrasena);
            pst.setString(4, this.email);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.");

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro" + e.getMessage());

        }
        return false;
    }

}
