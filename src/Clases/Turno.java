package Clases;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Turno {

    //Atributos de la clase
    private int idUsuario;
    private int idTurno;
    private String nombre;
    private String email;
    private int dni;
    private String horaTurno;
    private String fechaTurno;

    //Variables SQL
    ConexionSQL cc = new ConexionSQL();
    java.sql.Connection con = (Connection) cc.conexion();

    //Constructores
    public Turno(int idUsuario, String nombre, String email, int dni, String horaTurno, String fechaTurno) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.horaTurno = horaTurno;
        this.fechaTurno = fechaTurno;
    }

    public Turno(int idUsuario, int idTurno, String nombre, String email, int dni, String horaTurno, String fechaTurno) {
        this.idUsuario = idUsuario;
        this.idTurno = idTurno;
        this.nombre = nombre;
        this.email = email;
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
    
    //METODO UTILIZADO PARA LA CARGA DE LOS TURNOS, ESTA REALIZADA A TRAVES DE 
    //UN PROCEDIMIENTO ALMACENADO EN MYSQL
    //RETORNA TRUE SI EL TURNO ES CARGADO CORRECTAMENTE
    //RETORNA FALSE SI NO ES POSIBLE LA CARGA
    public boolean agregarTurno() {

        String SQL = "INSERT INTO turnos (idusuario, nombre, email, dni, hora_turno, dia_turno ) VALUES (?,?,?,?,?,?)";
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ps = con.prepareStatement(SQL);
            ps.setInt(1, this.idUsuario);
            ps.setString(2, this.nombre);
            ps.setString(3, this.email);
            ps.setInt(4, this.dni);
            ps.setString(5, this.horaTurno);
            ps.setString(6, this.fechaTurno);
            ps.executeUpdate();

            JavaEmail email = new JavaEmail();
            email.enviarEmail(this.email, this.fechaTurno, this.horaTurno);
            JOptionPane.showMessageDialog(null, "Turno cargado exitosamente. ");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro. " + e.getMessage());
        }
        return false;
    }
    
    
    //METODO UTILIZADO PARA LA MODIFICACION DE LOS TURNOS 
    //RECIBE COMO PARAMETRO EL IDTURNO
    //RETORNA TRUE SI EL TURNO ES MODIFICADO CORRECTAMENTE 
    //RETORNA FALSE SI NO ES POSIBLE MODIFICAR
    public boolean modificarTurno(int idTurno) {
        PreparedStatement ps = null;
        try {
            String SQL = "UPDATE turnos SET nombre=?, email=?, dni=?, dia_turno=?, hora_turno=? WHERE idturnos=" + idTurno;
            ps = con.prepareStatement(SQL);

            ps.setString(1, this.nombre);
            ps.setString(2, this.email);
            ps.setInt(3, this.dni);
            ps.setString(4, this.fechaTurno);
            ps.setString(5, this.horaTurno);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El turno se modifico satisfactoriamente.");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    //METODO UTILIZADO PARA LA ELIMINACION DE LOS TURNOS, RECIBE IDTURNO
    //DEVUELVE TRUE SI ES ELIMINADO CORRECTAMENTE
    //DEVUELVE FALSE SI NO ES POSIBLE LLEVAR A CABO LA ACCION
    public boolean eliminarTurno(int idTurno) {
        PreparedStatement ps = null;
        try {
            String SQL = "DELETE FROM turnos WHERE idturnos=?";
            ps = con.prepareStatement(SQL);

            ps.setInt(1, this.idTurno);
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //METODO UTILIZADO PARA CONTROLAR LA DISPONIBILIDAD DE TURNOS
    //DEVUELVE FALSE SI EXISTE UN TURNO CARGADO A LA MISMA HORA Y MISMO DIA
    //EN CASO DE EL HORARIO ESTE DISPONIBLE, DEVUELVE TRUE
    public boolean validarDisponibilidadTurno(){
        try{
            String SQL = "SELECT * FROM turnos WHERE idusuario='" + this.idUsuario + "' and hora_turno='" + this.horaTurno + "' and dia_turno='" + this.fechaTurno + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El horario no se encuentra disponible, por favor seleccione otro.");
                return false;
            }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }
    
    
    
    
}
