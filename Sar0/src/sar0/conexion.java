
package sar0;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class conexion {
    
   Connection conectar = null;
   String usuario="root";
   String contrasenia="root";
   String bd="sarsoporte";
   String puerto="3306";
   String ip="localhost";
   String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
          
   public Connection establecerConexion(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conectar=DriverManager.getConnection(cadena, usuario, contrasenia);
             //JOptionPane.showMessageDialog(null,"Conexión realizada");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e+"No existe conexión BD");
       }
        return conectar;
   }
}
   /*
   public void main probarConexion(){
     if(conect==null){
         JOptionPane.showMessageDialog(null, "NO conectado");
     }else{
      JOptionPane.showMessageDialog(null, "Conexión realizada");   
     }
  }*/