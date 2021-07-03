package Clases;
import Clases.ConexionSQL.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class Turno {
    
    //Atributos de la clase
    int idTurno;
    String nombre;
    String dni;
    
    DateTimeFormatter horaAlta;    
    
    
    //Constructores
    public Turno(){
     
    }
    
    public void setID(int id){
        this.idTurno = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDNI(String dni){
        this.dni = dni;
    }
    
    
    
    
    
}
