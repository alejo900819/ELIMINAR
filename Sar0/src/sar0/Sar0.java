package sar0;
import java.util.Scanner;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Sar0 {
        
    public static void main(String[] args) {
      
      InterfazUsuario objetointerfaz = new InterfazUsuario();
      objetointerfaz.setVisible(true);
      
      
    
       
        /*
        //CLIENTE
        //Ingreso nombre
        Cliente cliente1=new Cliente();
        System.out.println("Ingrese los nombres del cliente");
        Scanner sc=new Scanner  (System.in);
        cliente1.setNombres(sc.nextLine());
       //Ingreso apellido
        System.out.println("Ingrese los apellidos del cliente");
        Scanner sc1=new Scanner  (System.in);
        cliente1.setApellidos(sc1.nextLine());
        

       //EQUIPO
       //Marca del equipo
        Equipo equipo1=new Equipo();
        System.out.println("Ingrese la marca del equipo");
        Scanner sc2=new Scanner  (System.in);
        equipo1.setMarca(sc2.nextLine());
        
        //modelo del equipo
        System.out.println("Ingrese la Serie del equipo");
        Scanner sc3=new Scanner  (System.in);
        equipo1.setSerie(sc2.nextLine());
        
        //Orden de servicio
        //reporte inicial
        OrdenServicio Os1= new OrdenServicio();
        Os1.setIdOrdenServicio(1);
        System.out.println("Ingrese el reporte inicial del equipo");
        Scanner sc4=new Scanner  (System.in);
        Os1.setReporteIni(sc4.nextLine());
        
        //Reporte final
        System.out.println("Ingrese el reporte inicial del equipo");
        Scanner sc5=new Scanner  (System.in);
        Os1.setReporteFin(sc5.nextLine());
        
        //Factura
        //Valor repuestos
        Factura Fact1= new Factura();
        Fact1.setIdFactura(1234);
        System.out.println("Ingrese el valor de la revisión");
        Scanner sc6=new Scanner  (System.in);
        Fact1.setValorRevision(sc6.nextInt());
        System.out.println("Ingrese el valor de los repuestos");
        Scanner sc7= new Scanner (System.in);
        Fact1.setValorRepuestos(sc7.nextInt());
        Fact1.setValorTotal(Fact1.getValorRevision()+Fact1.getValorRepuestos());
        
        
        //fecha hoy
        System.out.println("             EMPRESA SAR");
        System.out.println("         RESUMEN DE REPORTE DE EQUIPO");
        System.out.println("Cliente: " + cliente1.getNombres()+ " "+ cliente1.getApellidos());
        System.out.println("Marca de equipo: "+ equipo1.getMarca());
        System.out.println("Serie de equipo: "+ equipo1.getSerie());
        System.out.println("Reporte inicial: "+ Os1.getReporteIni());
        System.out.println("Reporte fin: "+ Os1.getReporteFin());
        System.out.println("Valor Total: " + Fact1.getValorTotal());
        
  */           
}
}
