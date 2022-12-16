package sar0;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Equipo {

    //atributos
    private String modelo;
    private String tipo;
    private String marca;
    private String serie;
    private String color;
    private int idEquipo;
    
    //constructor
    
    public Equipo(){
}
    
    //metodos set an gat
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    //Metodo buscar equipo
    public void buscarEquipo(JTextField paraserie){
          setSerie(paraserie.getText());
    }
    //  metodo insertar equipo en bd
    public void insertarEquipo(JTextField paratipo, JTextField paramarca, JTextField paraserie,JTextField paracolor,JTextField paramodelo){
           setTipo(paratipo.getText());
           setMarca(paramarca.getText());
           setSerie(paraserie.getText());
           setColor(paracolor.getText());
           setModelo(paramodelo.getText());
           conexion objetoconexion1=new conexion();
           String consulta1="insert into sarsoporte.equipo (tipo,marca,serie,color,modelo) values (?,?,?,?,?);";
           try{
              
              CallableStatement cs1=(CallableStatement) objetoconexion1.establecerConexion().prepareCall(consulta1);
              cs1.setString(1, getTipo());
              cs1.setString(2, getMarca());
              cs1.setString(3, getSerie());
              cs1.setString(4, getColor());
              cs1.setString(5, getModelo());
                          
              cs1.execute();
              
              JOptionPane.showMessageDialog(null, "Equipo insertado");
              
              
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "Equipo no registrado, error: " + e.toString());
              }

    }
    /// metodo insertar equipo buscado en tabla de interfaz
         public void MostrarEquipos(JTable paraTablaTotalEquipos){
         conexion objetoconexion=new conexion();
         DefaultTableModel modelo= new DefaultTableModel();
         TableRowSorter<TableModel>OrdenarTabla= new TableRowSorter<TableModel>(modelo);
         paraTablaTotalEquipos.setRowSorter(OrdenarTabla);
         String sql="";
         modelo.addColumn("idEquipo");
         modelo.addColumn("tipo");
         modelo.addColumn("marca");
         modelo.addColumn("serie");
         modelo.addColumn("color");
         modelo.addColumn("modelo");
         
         paraTablaTotalEquipos.setModel(modelo);
         
         sql="select * from sarsoporte.equipo where serie='"+serie+"';";
        
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
           paraTablaTotalEquipos.setModel(modelo);
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());  
            
        }
     }
         
         public int existeEquipo(String serie){
         conexion objetoconexion=new conexion();
        Statement ps=null;
        ResultSet rs=null;
       String sql ="select count(*) from sarsoporte.equipo where serie='"+serie+"';";
       try{
           ps = objetoconexion.establecerConexion().createStatement();
           rs = ps.executeQuery(sql);
           if(rs.next()){
               return rs.getInt(1);
           }
           return 1;
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"Error ejecución consulta existencia equipo"+ e.toString());  
            return 1;
        }
        
         
     }
}
  