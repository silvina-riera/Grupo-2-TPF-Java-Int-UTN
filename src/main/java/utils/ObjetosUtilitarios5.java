
package utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.Cliente;
import modelos.Incidente;
import modelos.Servicio;
import modelos.TipoProblema;

public class ObjetosUtilitarios5 {
    
    public static Cliente cliente(){
        Cliente cliente = new Cliente();
        Set<Servicio> servicios = new HashSet<>();
        servicios.add(ObjetosUtilitarios5.servicio());
        cliente.setId(4);
        cliente.setRazonSocial("Roman Hnos. SRL");
        cliente.setCorreoElectronico("roman@gmail.com");
        cliente.setTelefono("113586983");
        cliente.setCuit("30142659025");
        cliente.setServicios(servicios);
        return cliente;
    }  
    
    public static Servicio servicio(){
        Servicio servicio = new Servicio();
        servicio.setId(3);
        servicio.setDescripcion("Tango Premium support");
        servicio.setTipoServicio("plan anual");
        return servicio;
    }

    public static TipoProblema problema1(){
        TipoProblema problema = new TipoProblema();
        problema.setId(4);
        problema.setDescripcion("No actualiza la facturación");
        problema.setTiempoEstimado(24);
        return problema;
    }
    
        public static TipoProblema problema2(){
        TipoProblema problema = new TipoProblema();
        problema.setId(5);
        problema.setDescripcion("Error al conectar con Afip");
        problema.setTiempoEstimado(12);
        return problema;
    }
    
    public static List<TipoProblema> listaProblemas(TipoProblema problema1, TipoProblema problema2){
        List<TipoProblema> listaProblemas = List.of(problema1, problema2);
        return listaProblemas;
    } 
     
     public static Incidente incidente5(){
         Incidente incidente = new  Incidente();
         incidente.setDescripcion("Error al actualizar factuaracion");
         incidente.setFechaCreacion(LocalDate.now());         
         return incidente;
     }
}
