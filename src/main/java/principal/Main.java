
package principal;

import java.util.ArrayList;
import modelos.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import repository.EntityManagerConfig;
import service.*;
import utils.ObjetosUtilitarios;

public class Main {
    public static void main(String[] args) {
        
       /**
        * Ciclo de vida de la aplicación      
        */
       
       EntityManager em = EntityManagerConfig.getEntityManager();
       
        // Se crea un cliente con un servicio asociado
        Cliente cliente = ObjetosUtilitarios.cliente();
        ClienteService clienteService = new ClienteService();
        clienteService.crearCliente(cliente);
        
        // Se agrega el cliente a la lista de clientes del objeto servicio
        ServicioService ss = new ServicioService();
        Servicio servicio = ss.buscarporDescripcion("Tango Full support");
        Set<Cliente> listaClientes = new HashSet<>();
        listaClientes.add(cliente);
        servicio.setClientes(listaClientes);
        ss.modificarServicio(servicio);
        
        // Se crea el operador
        Operador operador = ObjetosUtilitarios.operador();
        OperadorService opServ = new OperadorService();
        opServ.crearOperador(operador);
        
        // Se crea la especialidad
        Especialidad esp = ObjetosUtilitarios.Especialidad1();
        EspecialidadService espServ = new EspecialidadService();
        espServ.crearEspecialidad(esp);
        
        // Se crean los problemas 
        esp = espServ.findEspecialidadByNombre("Tango Windows");
        TipoProblema problema1 = ObjetosUtilitarios.problema1();
        ProblemaService ps = new ProblemaService();
        problema1.setEspecialidad(esp);
        ps.crearProblema(problema1);
        
        TipoProblema problema2 = ObjetosUtilitarios.problema2();
        problema2.setEspecialidad(esp);
        ps.crearProblema(problema2);
        
        // Se crean el técnico
        Tecnico tecnico = ObjetosUtilitarios.tecnico1();
        TecnicoService tecnicoService = new TecnicoService();
        esp = espServ.findEspecialidadByNombre("Tango Windows");
        operador = opServ.buscarporId(1);
        Set<Especialidad> listaEspecialidades = new HashSet<>();
        listaEspecialidades.add(esp);
        tecnico.setListaEspecialidades(listaEspecialidades);
        tecnico.setOperador(operador);
        tecnicoService.crearTecnico(tecnico);
        
        
        // Se genera el incidente
        Incidente incidente = ObjetosUtilitarios.incidente1();
        IncidenteService incServ = new IncidenteService();
        problema1 = ps.buscarporId(1);
        problema2 = ps.buscarporId(2);
        Set<TipoProblema> listaProblemas = new HashSet<>();
        listaProblemas.add(problema1);
        listaProblemas.add(problema2);
        // Calculo el tiempo de resolución
        incidente.setTiempoResolucion(incServ.sumarTiempoEstimado(listaProblemas));
        cliente = clienteService.findClienteByRazonSocial("UTN SRL");
        incidente.setCliente(cliente);
        servicio = ss.buscarporDescripcion("Tango Full support");
        incidente.setServicio(servicio);
        tecnico = tecnicoService.buscarporId(1);
        tecnico.setDisponibilidad(false);
        tecnicoService.modificarTecnicos(tecnico);
        incidente.setTecnico(tecnico);
        // Modifico estado de "Pendiente" a en "Proceso"
        incidente.modificarEstado();
        incServ.crearIncidente(incidente);
        
        // Relaciones adicionales
        
        // Seteo la lista de incidentes al cliente
        Set<Incidente> listaIncidentes = new HashSet<>();
        cliente = clienteService.findClienteByRazonSocial("UTN SRL");
        incidente = incServ.buscarporId(1);
        listaIncidentes.add(incidente);
        cliente.setIncidentes(listaIncidentes);
        clienteService.modificarCliente(cliente);
        
        // Seteo la lista de incidentes al tecnico
        tecnico = tecnicoService.buscarporId(1);
        incidente = incServ.buscarporId(1);
        tecnico.setIncidentes(listaIncidentes);
        tecnicoService.modificarTecnicos(tecnico);
        
        // Seteo el incidente al TipoProblema
        problema1 = ps.buscarporId(1);
        problema2 = ps.buscarporId(2);
        incidente = incServ.buscarporId(1);
        problema1.setIncidente(incidente);
        problema2.setIncidente(incidente);
        ps.modificarProblema(problema1);
        ps.modificarProblema(problema2);
        
        // Seteo la lista de técnicos y de problemas a la especialidad correspondiente 
        Set<Tecnico> listaTecnicos = new HashSet<>();
        listaTecnicos.add(tecnico);
        Especialidad especialidad = espServ.buscarporId(1);
        especialidad.setListaTecnicos(listaTecnicos);
        
        Set<TipoProblema> problemas = new HashSet<>();
        problemas.add(problema1);
        problemas.add(problema2);
        especialidad.setListaProblemas(problemas);
        espServ.modificarEspecialidad(especialidad);
        
        // Seteo la lista de técnicos a operador y el incidente
        List<Tecnico> allTecnicos = new ArrayList<>();
        allTecnicos = tecnicoService.findAll();
        Set<Tecnico> toSet = new HashSet<>(allTecnicos);
        operador.setListaTecnicos(toSet);
        operador.setIncidente(incidente);
        opServ.modificarOperador(operador);
        
        em.close();
    }
    
}
