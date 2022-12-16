package sar0;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Factura extends OrdenServicio{

    //atributos
    private int idFactura;
    private int valorReviRepa;
    private int valorRepuestos;
    private int valorTotal;
    private int cedula;
    private int ordenServicio;
    
    //constructor
    public Factura(){
    }
    
        public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getOrdenServicio() {
        return ordenServicio;
    }

    //set & Get
    public void setOrdenServicio(int ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getValorReviRepa() {
        return valorReviRepa;
    }

    public void setValorReviRepa(int valorReviRepa) {
        this.valorReviRepa = valorReviRepa;
    }

    public int getValorRepuestos() {
        return valorRepuestos;
    }

    public void setValorRepuestos(int valorRepuestos) {
        this.valorRepuestos = valorRepuestos;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void insertarFactura(JTextField paravalorReviRepa, JTextField paravalorRepuestos,JTextField paracedula, JTextField paraordenServicio){
        setValorReviRepa(Integer.parseInt(paravalorReviRepa.getText())); 
        setValorRepuestos(Integer.parseInt(paravalorRepuestos.getText()));
        setCedula(Integer.parseInt(paracedula.getText()));
        setOrdenServicio(Integer.parseInt(paraordenServicio.getText()));
        valorTotal=valorReviRepa+valorRepuestos;
               
          conexion objetoconexion=new conexion();
          
          String consulta="insert into sarsoporte.factura (valorReviRepa,valorRepuestos,valorTotal,cedula,idOrdenServicio) values (?,?,?,?,?);";
          
          try{
              CallableStatement cs=objetoconexion.establecerConexion().prepareCall(consulta);
              cs.setInt(1, getValorReviRepa());
              cs.setInt(2, getValorRepuestos());
              cs.setInt(3, getValorTotal());
              cs.setInt(4, getCedula());
              cs.setInt(5, getOrdenServicio());
              
              cs.execute();
              
              JOptionPane.showMessageDialog(null, "Factura generada Correctamente.");
              
              
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "Factura no registrada, error: " + e.toString());
              }
        }
   
}
