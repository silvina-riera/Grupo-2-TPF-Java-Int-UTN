
package utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.Cliente;
import modelos.Incidente;
import modelos.Servicio;
import modelos.TipoProblema;

public class ObjetosUtilitarios4 {
    
    public static Cliente cliente(){
        Cliente cliente = new Cliente();
        Set<Servicio> servicios = new HashSet<>();
        servicios.add(ObjetosUtilitarios4.servicio());
        cliente.setId(4);
        cliente.setRazonSocial("Flandes SRL");
        cliente.setCorreoElectronico("flandes@gmail.com");
        cliente.setTelefono("11632658007");
        cliente.setCuit("30180529035");
        cliente.setServicios(servicios);
        return cliente;
    }  
    
    public static Servicio servicio(){
        Servicio servicio = new Servicio();
        servicio.setId(3);
        servicio.setDescripcion("Tango basic support Anual");
        servicio.setTipoServicio("plan anual");
        return servicio;
    }

    public static TipoProblema problema1(){
        TipoProblema problema = new TipoProblema();
        problema.setId(4);
        problema.setDescripcion("Error al imprimir");
        problema.setTiempoEstimado(36);
        return problema;
    }
    
        public static TipoProblema problema2(){
        TipoProblema problema = new TipoProblema();
        problema.setId(5);
        problema.setDescripcion("Error al generar comprobante");
        problema.setTiempoEstimado(18);
        return problema;
    }
    
    public static List<TipoProblema> listaProblemas(TipoProblema problema1, TipoProblema problema2){
        List<TipoProblema> listaProblemas = List.of(problema1, problema2);
        return listaProblemas;
    } 
     
     public static Incidente incidente4(){
         Incidente incidente = new  Incidente();
         incidente.setDescripcion("Error al imprimir comprobantes");
         incidente.setFechaCreacion(LocalDate.now());         
         return incidente;
     }
}
