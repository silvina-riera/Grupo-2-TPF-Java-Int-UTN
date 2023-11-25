
package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.*;
import service.*;

public class CicloVida {

    public void crearCliente(Cliente cliente, String descripcionServicio){
        // Se crea un cliente con un servicio asociado
        ClienteService clienteService = new ClienteService();
        clienteService.crearCliente(cliente);
        
        // Se agrega el cliente creado a la lista de clientes del servicio
        ServicioService ss = new ServicioService();
        Servicio servicio = ss.buscarporDescripcion(descripcionServicio);
        Set<Cliente> listaClientes = new HashSet<>();
        listaClientes.add(cliente);
        servicio.setClientes(listaClientes);
        ss.modificarServicio(servicio);
    }
    
    public void crearOperador(Operador operador){
        // Se crea el operador
        OperadorService opServ = new OperadorService();
        opServ.crearOperador(operador);
    }
    
    public void crearEspecialidad(Especialidad esp){
        // Se crea la especialidad
        EspecialidadService espServ = new EspecialidadService();
        espServ.crearEspecialidad(esp);
    }
    
    
    public void crearProblema(TipoProblema problema, String nombreEspecialidad){
        // Se crea el problema y se lo asocia a una especialidad determinada 
        EspecialidadService service = new EspecialidadService();
        Especialidad esp = service.findEspecialidadByNombre(nombreEspecialidad);
        ProblemaService ps = new ProblemaService();
        problema.setEspecialidad(esp);
        ps.crearProblema(problema);
    }
    
    public void crearTecnico(Tecnico tecnico, String nombreEspecialidad, int idOperador){
        TecnicoService tecnicoService = new TecnicoService();
        // se setean la lista de especialidades
        EspecialidadService espServ = new EspecialidadService();
        Especialidad esp = espServ.findEspecialidadByNombre(nombreEspecialidad);
        Set<Especialidad> listaEspecialidades = new HashSet<>();
        listaEspecialidades.add(esp);
        tecnico.setListaEspecialidades(listaEspecialidades);
        // se setea el operador
        OperadorService opServ = new OperadorService();
        Operador operador = opServ.buscarporId(idOperador);
        tecnico.setOperador(operador);
        // Se crea el técnico
        tecnicoService.crearTecnico(tecnico);
    }
    
    public void crearIncidente(Incidente incidente, String razonSocial, int idTecnico, 
            String descripcionServicio, List<TipoProblema> problemas){
         // Se genera el incidente
        IncidenteService incServ = new IncidenteService();
        
        // Se setea la lista de problemas
        ProblemaService ps = new ProblemaService();
        TipoProblema problema1 = problemas.get(0);
        TipoProblema problema2 = problemas.get(1);
        problema1 = ps.buscarporId(problema1.getId());
        problema2 = ps.buscarporId(problema2.getId());
        Set<TipoProblema> listaProblemas = new HashSet<>();
        listaProblemas.add(problema1);
        listaProblemas.add(problema2);
        
        // Calculo el tiempo de resolución
        incidente.setTiempoResolucion(incServ.sumarTiempoEstimado(listaProblemas));
       
        // Seteo el cliente
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.findClienteByRazonSocial(razonSocial);
        incidente.setCliente(cliente);
        
        // Seteo el servicio
        ServicioService ss = new ServicioService();
        Servicio servicio = ss.buscarporDescripcion(descripcionServicio);
        incidente.setServicio(servicio);
        
        // Seteo el técnico
        TecnicoService tecnicoService = new TecnicoService();
        Tecnico tecnico = tecnicoService.buscarporId(idTecnico);
        tecnico.setDisponibilidad(false);
        tecnicoService.modificarTecnicos(tecnico);
        incidente.setTecnico(tecnico);
        // Modifico estado de "Pendiente" a en "Proceso"
        incidente.modificarEstado();
        incServ.crearIncidente(incidente);
    }
    
    public void actualizarCliente(String razonSocial, int idIncidente){
        // Seteo la lista de incidentes al cliente
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.findClienteByRazonSocial(razonSocial);
        
        // Actualizo la lista de incidentes del cliente
        IncidenteService incServ = new IncidenteService();
        Incidente incidente = incServ.buscarporId(idIncidente);
        Set<Incidente> listaIncidentes = new HashSet<>();
        listaIncidentes.add(incidente);
        cliente.setIncidentes(listaIncidentes);
        clienteService.modificarCliente(cliente);
    }
    
    public void actualizarTecnico(int idTecnico, int idIncidente){              
        // Seteo la lista de incidentes al tecnico
        TecnicoService tecnicoService = new TecnicoService();
        Tecnico tecnico = tecnicoService.buscarporId(idTecnico);
        
        // Actualizo la lista de incidentes del servicio
        IncidenteService incServ = new IncidenteService();
        Incidente incidente = incServ.buscarporId(idIncidente);
        Set<Incidente> listaIncidentes = new HashSet<>();
        listaIncidentes.add(incidente);
        tecnico.setIncidentes(listaIncidentes);
        tecnicoService.modificarTecnicos(tecnico);
    }
    
    public void actualizarTipoProblema(int idProblema, int idIncidente){
        // Seteo el incidente al TipoProblema
        ProblemaService ps = new ProblemaService();
        TipoProblema problema = ps.buscarporId(idProblema);
        IncidenteService incServ = new IncidenteService();
        Incidente incidente = incServ.buscarporId(idIncidente);
        problema.setIncidente(incidente);
        ps.modificarProblema(problema);
    }
    
    public void actualizarEspecialidadTecnicos(int idEspecialidad, int idTecnico){
        // Seteo la lista de técnicos a la especialidad correspondiente
        EspecialidadService espServ = new EspecialidadService();
        Especialidad especialidad = espServ.buscarporId(idEspecialidad);
        Set<Tecnico> listaTecnicos = new HashSet<>();
        TecnicoService tecnicoService = new TecnicoService();
        Tecnico tecnico = tecnicoService.buscarporId(idTecnico);
        listaTecnicos.add(tecnico);
        especialidad.setListaTecnicos(listaTecnicos);      
    }
    
    public void actualizarEspecialidadProblemas(int idEspecialidad, int idProblema){
        // Seteo la lista de problemas a la especialidad correspondiente
        EspecialidadService espServ = new EspecialidadService();
        Especialidad especialidad = espServ.buscarporId(idEspecialidad);
        Set<TipoProblema> problemas = new HashSet<>();
        ProblemaService ps = new ProblemaService();
        TipoProblema problema = ps.buscarporId(idProblema);
        problemas.add(problema);
        especialidad.setListaProblemas(problemas);
        espServ.modificarEspecialidad(especialidad);       
    }
    
    public void actualizarOperador(int idOperador, int idIncidente){
        // Seteo a operador la lista de técnicos y el incidente
        OperadorService opServ = new OperadorService();
        Operador operador = opServ.buscarporId(idOperador);
        
        List<Tecnico> allTecnicos = new ArrayList<>();
        TecnicoService tecnicoService = new TecnicoService();
        allTecnicos = tecnicoService.findAll();
        Set<Tecnico> toSet = new HashSet<>(allTecnicos);
        operador.setListaTecnicos(toSet);
        
        IncidenteService incServ = new IncidenteService();
        Incidente incidente = incServ.buscarporId(idIncidente);
        operador.setIncidente(incidente);
        opServ.modificarOperador(operador);
    }
    
    public void incidenteResuelto(int id){
        IncidenteService service = new IncidenteService();
        TecnicoService tecnicoService = new TecnicoService();
        LocalDate fechaCierre = LocalDate.parse("2023-11-25");
        Incidente incidente = service.buscarporId(id);
        Tecnico tecnico = incidente.getTecnico();
        tecnico.setDisponibilidad(true);
        incidente.setFechaCierre(fechaCierre);
        incidente.modificarEstado();
        tecnicoService.modificarTecnicos(tecnico);
        service.modificarIncidente(incidente);
    } 
}
