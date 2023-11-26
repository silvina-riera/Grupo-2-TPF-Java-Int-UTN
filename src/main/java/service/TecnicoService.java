package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import modelos.EEstado;
import modelos.Incidente;
import modelos.Tecnico;
import repository.TecnicoRepository;

public class TecnicoService {

    private final TecnicoRepository repository = new TecnicoRepository();
    private final IncidenteService servicioIncidente = new IncidenteService();

    public void crearTecnico(Tecnico tecnico) {
        repository.saveTecnico(tecnico);
    }

    public Tecnico buscarporId(int id) {
        return repository.findTecnicoPorId(id);
    }

    public List<Tecnico> findAll() {
        return repository.findAllTecnicos();
    }

    public void modificarTecnicos(Tecnico tecnico) {
        repository.updateTecnico(tecnico);
    }

    public void delete(Tecnico tecnico) {
        repository.delete(tecnico);
    }

    public Tecnico resueltosporFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
        List<Incidente> incidentes = repository.obtenerResueltosPorFecha(estado, fecha1, fecha2);
        Map<Tecnico, Long> resueltos = incidentes.stream().collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
        Tecnico tecnicoConMasIncidentes = resueltos.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        return tecnicoConMasIncidentes;
    }

    /**
     * **************Metodo 1*******************
     */
    public Optional<Map.Entry<Tecnico, Long>> obtenerTecnicoConMasIncidentesResueltosUltimosNDias(int nDias) {
        return maximoCantidadIncidente(tecnicoPorCantidadIncident(nDias));

    }

    private Map<Tecnico, Long> tecnicoPorCantidadIncident(int nDias) {

        //Obtengo un listado filtrado por dias de incidentes
        List<Incidente> incidentesFiltrados = servicioIncidente.listarPorXDias(nDias);

        // agrupar por tecnicos
        Map<Tecnico, Long> conteoIncidentesPorTecnico;
        conteoIncidentesPorTecnico = incidentesFiltrados.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting())); // Filtra incidentes no nulos

        return conteoIncidentesPorTecnico;

    }

    private Optional<Map.Entry<Tecnico, Long>> maximoCantidadIncidente(Map<Tecnico, Long> conteoIncidentesPorTecnico) {
        //Devuelve una coleccion con el maximo de incidentes
        Optional<Map.Entry<Tecnico, Long>> maxEntry = conteoIncidentesPorTecnico.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        return maxEntry;

    }

    /**
     * ***************Metodo 2*******************
     */
    public Optional<Map.Entry<Tecnico, Long>> tecnicoConMaximaCantidadDeIncidentesEnEspecialidad(String especialidad, int nDias) {
        //Almacena la lista de los incidentses x dias y especialidad
        List<Incidente> listadoEspecialidad = listarPorXDiasEspecialidad(especialidad, nDias);

        //Almacena la coleccion con el conteo x especialidad
        Map<Tecnico, Long> totalIncidentes = contarIncidentesPorTecnico(listadoEspecialidad);

        //almacena el Tecnico con mayor incidencia
        Optional<Map.Entry<Tecnico, Long>> maximoIncidente = tecnicoMaxCantidadIncidente(totalIncidentes);

        return maximoIncidente;

    }

    private List<Incidente> listarPorXDiasEspecialidad(String especialidad, int nDias) {
        List<Incidente> resultado = servicioIncidente.listarPorXDias(nDias);
        return resultado.stream()
                .filter(incidente -> incidente.getTecnico().getListaEspecialidades().contains(especialidad))
                .collect(Collectors.toList());
    }

    private Map<Tecnico, Long> contarIncidentesPorTecnico(List<Incidente> incidentes) {
        return incidentes.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
    }

    private Optional<Map.Entry<Tecnico, Long>> tecnicoMaxCantidadIncidente(Map<Tecnico, Long> conteoIncidentesPorTecnico) {
        return conteoIncidentesPorTecnico.entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

}
