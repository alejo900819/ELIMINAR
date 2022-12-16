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

public class OrdenServicio {

    //atributos
    private int idOrdenServicio;
    private String reporteIni;
    private String reporteFin;
    private String repuestos;
    private String serie;
    private String numcedula;

    public String getNumcedula() {
        return numcedula;
    }

    public void setNumcedula(String numcedula) {
        this.numcedula = numcedula;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    //constructor
  public OrdenServicio(){
} 
  //Set & Get
  
  public int getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(int idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public String getReporteIni() {
        return reporteIni;
    }

    public void setReporteIni(String reporteIni) {
        this.reporteIni = reporteIni;
    }

    public String getReporteFin() {
        return reporteFin;
    }

    public void setReporteFin(String reporteFin) {
        this.reporteFin = reporteFin;
    }

    public String getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }
    
    public void insertarOrdenServicio(JTextField parareporteIni, JTextField parareporteFin, JTextField pararepuestos,JTextField paraserie,JTextField paranumcedula){
           setReporteIni(parareporteIni.getText());
           setReporteFin(parareporteFin.getText());
           setRepuestos(pararepuestos.getText());
           setSerie(paraserie.getText());
           setNumcedula(paranumcedula.getText());
           
           conexion objetoconexion1=new conexion();
           String consulta1="insert into sarsoporte.ordenservicio (reporteIni,reporteFin,repuestos,serie,numcedula) values (?,?,?,?,?);";
           try{
              
              CallableStatement cs1=(CallableStatement) objetoconexion1.establecerConexion().prepareCall(consulta1);
              cs1.setString(1, getReporteIni());
              cs1.setString(2, getReporteFin());
              cs1.setString(3, getRepuestos());
              cs1.setString(4,getSerie());
              cs1.setString(5,getNumcedula());
                             
              cs1.execute();
              
              JOptionPane.showMessageDialog(null, "Orden de Servicio insertada");           
              
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "Orden de servicio no insertada, error: " + e.toString());
              }
}
    
    public void buscarcedula(JTextField paranumcedula){
          setNumcedula(paranumcedula.getText());
    }
    
    public void MostrarOrdenServicio(JTable paraTablaOrdenServicio){
         conexion objetoconexion=new conexion();
         DefaultTableModel modelo= new DefaultTableModel();
         TableRowSorter<TableModel>OrdenarTabla= new TableRowSorter<TableModel>(modelo);
         paraTablaOrdenServicio.setRowSorter(OrdenarTabla);
         String sql="";
         modelo.addColumn("IDORSERVICIO");
         modelo.addColumn("REPORTE INI");
         modelo.addColumn("REPORTE FIN");
         modelo.addColumn("REPUESTOS");
         modelo.addColumn("SERIE");
         modelo.addColumn("CÉDULA");
         
         paraTablaOrdenServicio.setModel(modelo);
         
        sql="select * from sarsoporte.ordenservicio where numcedula="+numcedula+";";
        
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
           paraTablaOrdenServicio.setModel(modelo);
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());  
            
        }
     }
    public int existeOrdenServicio(String idOrdenServicio){
         conexion objetoconexion=new conexion();
        Statement ps=null;
        ResultSet rs=null;
       String sql ="select count(*) from sarsoporte.ordenservicio where idOrdenServicio='"+idOrdenServicio+"';";
       try{
           ps = objetoconexion.establecerConexion().createStatement();
           rs = ps.executeQuery(sql);
           if(rs.next()){
               return rs.getInt(1);
           }
           return 1;
        }catch (Exception e){
          JOptionPane.showMessageDialog(null,"Error ejecución consulta existencia orden servicio"+ e.toString());  
            return 1;
        }
        
         
     }
}
