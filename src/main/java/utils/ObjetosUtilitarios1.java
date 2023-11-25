
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

public class ObjetosUtilitarios1 {
    
    public static Cliente cliente(){
        Cliente cliente = new Cliente();
        Set<Servicio> servicios = new HashSet<>();
        servicios.add(ObjetosUtilitarios1.servicio());
        cliente.setId(1);
        cliente.setRazonSocial("UTN SRL");
        cliente.setCorreoElectronico("utn@gmail.com");
        cliente.setTelefono("1152478359");
        cliente.setCuit("30156987435");
        cliente.setServicios(servicios);
        return cliente;
    }  
    
    public static Servicio servicio(){
        Servicio servicio = new Servicio();
        servicio.setId(1);
        servicio.setDescripcion("Tango Full support");
        servicio.setTipoServicio("plan anual");
        return servicio;
    }
    
    public static Especialidad Especialidad1(){
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Tango Windows");
        especialidad.setDescripcion("problemas de Tango vinculados a su funcionamiento en Windows");
        return especialidad;
    } 
    
    public static Especialidad Especialidad2(){
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("SAP Linux");
        especialidad.setDescripcion("problemas de SAP vinculados a su funcionamiento en Linux");
        return especialidad;
    } 
    
    public static Especialidad Especialidad3(){
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Tango MacOS");
        especialidad.setDescripcion("problemas de Tango vinculados a su funcionamiento en MacOS");
        return especialidad;
    } 
    
    public static Operador operador(){
        Operador operador = new Operador();
        operador.setNombre("Ricardo");
        operador.setApellido("Flores");
        return operador;
    }
    
    public static Tecnico tecnico1(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Jorge");
        tecnico.setApellido("Lopez");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.TELEFONO);
        return tecnico;
    } 
    
    public static Tecnico tecnico2(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Anibal");
        tecnico.setApellido("Gonzalez");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.EMAIL);
        return tecnico;
    } 
    
    public static Tecnico tecnico3(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Juan Carlos");
        tecnico.setApellido("Flecher");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.WHATSAPP);
        return tecnico;
    } 
    
    public static Tecnico tecnico4(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Ana");
        tecnico.setApellido("Sanchez");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.WHATSAPP);
        return tecnico;
    } 
    
    public static Tecnico tecnico5(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Lorena");
        tecnico.setApellido("Marcel");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.TELEFONO);
        return tecnico;
    } 
    
    public static Tecnico tecnico6(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Micaela");
        tecnico.setApellido("Estrada");
        tecnico.setDisponibilidad(true);
        tecnico.setNotificacion(MedioNotificacionEnum.EMAIL);
        return tecnico;
    } 
    
    public static TipoProblema problema1(){
        TipoProblema problema = new TipoProblema();
        problema.setId(1);
        problema.setDescripcion("Error dll de Tango");
        problema.setTiempoEstimado(48);
        return problema;
    }
    
     public static TipoProblema problema2(){
        TipoProblema problema = new TipoProblema();
        problema.setId(2);
        problema.setDescripcion("Error registro windows");
        problema.setTiempoEstimado(24);
        return problema;
    }
     
     public static TipoProblema problema3(){
        TipoProblema problema = new TipoProblema();
        problema.setId(3);
        problema.setDescripcion("Error instalacion Linux");
        problema.setTiempoEstimado(32);
        return problema;
    }
     
    public static List<TipoProblema> listaProblemas(TipoProblema problema1, TipoProblema problema2){
        List<TipoProblema> listaProblemas = List.of(problema1, problema2);
        return listaProblemas;
    } 
     
     public static Incidente incidente1(){
         Incidente incidente = new  Incidente();
         incidente.setDescripcion("Error al iniciar Tango con Windows 10");
         incidente.setFechaCreacion(LocalDate.now());         
         return incidente;
     }
}
