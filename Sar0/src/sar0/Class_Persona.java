//clase padre
package sar0;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Statement;
public class Class_Persona {
    //Atributos
    private int numcedula;
    private String telefono;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;
   
    //Constructores
    public Class_Persona(){
    }
    
    public Class_Persona(int numcedula,String telefono, String nombres, String apellidos, 
            String direccion, String correo){
        this.numcedula=numcedula;
        this.telefono=telefono;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.direccion=direccion;
        this.correo=correo;
            
    }
    
    // Métodos Set and Get
    public int getNumcedula() {
        return numcedula;
    }

    public void setNumcedula(int numcedula) {
        this.numcedula = numcedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
        //metodo buscar persona
    public void buscarPersona(JTextField paranumcedula){
          setNumcedula(Integer.parseInt(paranumcedula.getText()));
    }
       // Metodo de inserción desde Forms
            public void insertarPersona(JTextField paranumcedula, JTextField paranombres, JTextField paraapellidos,JTextField paracorreo, JTextField paradireccion, JTextField paratelefono){
          setNumcedula(Integer.parseInt(paranumcedula.getText()));
          setNombres(paranombres.getText());
          setApellidos(paraapellidos.getText());
          setCorreo (paracorreo.getText());
          setDireccion(paradireccion.getText());
          setTelefono(paratelefono.getText());
          
          conexion objetoconexion=new conexion();
          
          String consulta="insert into sarsoporte.persona (nombres,apellidos,correo,numcedula,direccion,telefono) values (?,?,?,?,?,?);";
          
          try{
              
              CallableStatement cs=objetoconexion.establecerConexion().prepareCall(consulta);
              cs.setString(1, getNombres());
              cs.setString(2, getApellidos());
              cs.setString(3, getCorreo());
              cs.setInt(4, getNumcedula());
              cs.setString(5, getDireccion());
              cs.setString(6, getTelefono());
              
              cs.execute();
              
              JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
              
              
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "No registrados, error: " + e.toString());
              }
        }
     public void MostrarPersonas(JTable paraTablaTotalPersonas){
         conexion objetoconexion=new conexion();
         DefaultTableModel modelo= new DefaultTableModel();
         TableRowSorter<TableModel>OrdenarTabla= new TableRowSorter<TableModel>(modelo);
         paraTablaTotalPersonas.setRowSorter(OrdenarTabla);
         String sql="";
         modelo.addColumn("numcedula");
         modelo.addColumn("nombres");
         modelo.addColumn("apellidos");
         modelo.addColumn("telefono");
         modelo.addColumn("direccion");
         modelo.addColumn("correo");
         
         paraTablaTotalPersonas.setModel(modelo);
         
        sql="select * from sarsoporte.persona where numcedula="+numcedula+";";
        
        String[]datos= new String[6];
        Statement st;
                try{
            st= objetoconexion.establecerConexion().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
            
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                
                modelo.addRow(datos);
            }
           paraTablaTotalPersonas.setModel(modelo);
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());  
            
        }
     }
     
     public int existePersona(String numcedula){
         conexion objetoconexion=new conexion();
        Statement ps=null;
        ResultSet rs=null;
       String sql ="select count(*) from sarsoporte.persona where numcedula='"+numcedula+"';";
       try{
           ps = objetoconexion.establecerConexion().createStatement();
           rs = ps.executeQuery(sql);
           if(rs.next()){
               return rs.getInt(1);
           }
           return 1;
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"Error ejecución consulta existencia cliente"+ e.toString());  
            return 1;
        }
        
         
     }
}
