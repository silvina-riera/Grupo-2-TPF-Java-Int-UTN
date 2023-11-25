
package utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.Cliente;
import modelos.Especialidad;
import modelos.Incidente;
import modelos.MedioNotificacionEnum;
import modelos.Operador;
import modelos.Servicio;
import modelos.Tecnico;
import modelos.TipoProblema;

public class ObjetosUtilitarios2 {
    
     public static Cliente cliente(){
        Cliente cliente = new Cliente();
        Set<Servicio> servicios = new HashSet<>();
        servicios.add(ObjetosUtilitarios2.servicio());
        cliente.setId(2);
        cliente.setRazonSocial("Sauce SA");
        cliente.setCorreoElectronico("sauce@gmail.com");
        cliente.setTelefono("116014589");
        cliente.setCuit("30255689705");
        cliente.setServicios(servicios);
        return cliente;
    }  
    
    public static Servicio servicio(){
        Servicio servicio = new Servicio();
        servicio.setId(2);
        servicio.setDescripcion("SAP Full support");
        servicio.setTipoServicio("plan anual");
        return servicio;
    }
    
    public static Especialidad Especialidad2(){
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("SAP Linux");
        especialidad.setDescripcion("problemas de SAP vinculados a su funcionamiento en Linux");
        return especialidad;
    } 
   
    
    public static Operador operador(){
        Operador operador = new Operador();
        operador.setNombre("Sandra");
        operador.setApellido("Roca");
        return operador;
    }
    
    public static Tecnico tecnico2(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Anibal");
        tecnico.setApellido("Gonzalez");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.EMAIL);
        return tecnico;
    } 

    public static TipoProblema problema1(){
        TipoProblema problema = new TipoProblema();
        problema.setId(3);
        problema.setDescripcion("Error libreria de SAP");
        problema.setTiempoEstimado(36);
        return problema;
    }
    
        public static TipoProblema problema2(){
        TipoProblema problema = new TipoProblema();
        problema.setId(4);
        problema.setDescripcion("Error ejecutar SAP");
        problema.setTiempoEstimado(48);
        return problema;
    }
    
    public static List<TipoProblema> listaProblemas(TipoProblema problema1, TipoProblema problema2){
        List<TipoProblema> listaProblemas = List.of(problema1, problema2);
        return listaProblemas;
    } 
     
     public static Incidente incidente2(){
         Incidente incidente = new  Incidente();
         incidente.setDescripcion("Error al ejecutar SAP");
         incidente.setFechaCreacion(LocalDate.now());         
         return incidente;
     }
    
}
