package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Turno {

    //Atributos de la clase
    private int idUsuario;
    private int idTurno;
    private String nombre;
    private int dni;
    private String horaTurno;
    private String fechaTurno;

    //Variables SQL
    ConexionSQL cc = new ConexionSQL();
    java.sql.Connection con = (Connection) cc.conexion();

    //Constructores
    public Turno(int idUsuario, String nombre, int dni, String horaTurno, String fechaTurno) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.horaTurno = horaTurno;
        this.fechaTurno = fechaTurno;
    }

    public Turno(int idUsuario, int idTurno, String nombre, int dni, String horaTurno, String fechaTurno) {
        this.idUsuario = idUsuario;
        this.idTurno = idTurno;
        this.nombre = nombre;
        this.dni = dni;
        this.horaTurno = horaTurno;
        this.fechaTurno = fechaTurno;
    }

    //METODOS GETTERS  
    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getHoraTurno() {
        return horaTurno;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    //METODOS SETTERS
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    //OTROS METODOS
    public boolean agregarTurno() {

        String SQL = "CALL insertarEnTurnos_sp (?,?,?,?,?,?)";
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ps = con.prepareStatement(SQL);
            ps.setInt(1, this.idUsuario);
            ps.setString(2, this.nombre);
            ps.setInt(3, this.dni);
            ps.setString(4, formatter.format(date));
            ps.setString(5, this.horaTurno);
            ps.setString(6, this.fechaTurno);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Turno cargado exitosamente. ");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro. " + e.getMessage());
        }
        return false;
    }

    public boolean modificarTurno(int idTurno) {
        PreparedStatement ps = null;
        try {
            String SQL = "UPDATE turnos SET nombre=?, dni=?, dia_turno=?, hora_turno=? WHERE idturno=" + idTurno;
            ps = con.prepareStatement(SQL);

            ps.setString(1, this.nombre);
            ps.setInt(2, this.dni);
            ps.setString(3, this.fechaTurno);
            ps.setString(4, this.horaTurno);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El turno se modifico satisfactoriamente.");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean eliminarTurno(int idTurno) {
        PreparedStatement ps = null;
        try {
            String SQL = "DELETE FROM turnos WHERE idturno=?";
            ps = con.prepareStatement(SQL);

            ps.setInt(1, this.idTurno);
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
