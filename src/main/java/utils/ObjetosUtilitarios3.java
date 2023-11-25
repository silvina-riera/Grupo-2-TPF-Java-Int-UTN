
package utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.*;


public class ObjetosUtilitarios3 {
    
     public static Cliente cliente(){
        Cliente cliente = new Cliente();
        Set<Servicio> servicios = new HashSet<>();
        servicios.add(ObjetosUtilitarios3.servicio());
        cliente.setId(3);
        cliente.setRazonSocial("Rio SA");
        cliente.setCorreoElectronico("riosa@gmail.com");
        cliente.setTelefono("1132475980");
        cliente.setCuit("30216809045");
        cliente.setServicios(servicios);
        return cliente;
    }  
    
    public static Servicio servicio(){
        Servicio servicio = new Servicio();
        servicio.setId(3);
        servicio.setDescripcion("Tango basic support");
        servicio.setTipoServicio("plan mensual");
        return servicio;
    }
    
    public static Operador operador(){
        Operador operador = new Operador();
        operador.setNombre("Victoria");
        operador.setApellido("Sosa");
        return operador;
    }
    
    public static Tecnico tecnico3(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Juan Carlos");
        tecnico.setApellido("Flecher");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.WHATSAPP);
        return tecnico;
    } 

    public static TipoProblema problema1(){
        TipoProblema problema = new TipoProblema();
        problema.setId(4);
        problema.setDescripcion("Error conexion Base de Datos");
        problema.setTiempoEstimado(36);
        return problema;
    }
    
        public static TipoProblema problema2(){
        TipoProblema problema = new TipoProblema();
        problema.setId(5);
        problema.setDescripcion("Error al guardar");
        problema.setTiempoEstimado(36);
        return problema;
    }
    
    public static List<TipoProblema> listaProblemas(TipoProblema problema1, TipoProblema problema2){
        List<TipoProblema> listaProblemas = List.of(problema1, problema2);
        return listaProblemas;
    } 
     
     public static Incidente incidente3(){
         Incidente incidente = new  Incidente();
         incidente.setDescripcion("Error al guardar datos");
         incidente.setFechaCreacion(LocalDate.now());         
         return incidente;
     }
    
}
