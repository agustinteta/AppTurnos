package Clases;

import java.awt.Panel;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaEmail {
    
    public JavaEmail(){
        
    }
    public boolean enviarEmail(String emailReceptor, String fecha, String hora) throws MessagingException{
        Properties propiedad = new Properties();
        propiedad.setProperty("email.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");        

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "agustinteta@hotmail.com";
        String contrasena = "Agusstin1998!";
        String receptor = emailReceptor;
        String asunto = "Confirmacion de Turno!";
        String mensaje= "Se ha generado un turno de forma exitosa para el dia:"+fecha+" y la hora:"+hora;
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro. " + e.getMessage());
        }
        return true;
        
    }
}
