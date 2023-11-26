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
        return cantidadIncidentesPorTecnico(nDias);

    }

    private Optional<Map.Entry<Tecnico, Long>> cantidadIncidentesPorTecnico(int nDias) {

        //Obtengo un listado filtrado por dias de incidentes
        List<Incidente> incidentesFiltrados = servicioIncidente.listarPorXDias(nDias);

        // agrupar por tecnicos
        Map<Tecnico, Long> conteoIncidentesPorTecnico;
        conteoIncidentesPorTecnico = incidentesFiltrados.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting())); // Filtra incidentes no nulos

        //paso el map al metodo
        return maximoCantidadIncidente(conteoIncidentesPorTecnico);

    }

    private Optional<Map.Entry<Tecnico, Long>> maximoCantidadIncidente(Map<Tecnico, Long> conteoIncidentesPorTecnico) {
        //Devuelve una coleccion con el maximo de incidentes
        Optional<Map.Entry<Tecnico, Long>> maxEntry = conteoIncidentesPorTecnico.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        return maxEntry;

    }
    /**
     * **************Metodo 2*******************
     */
    public List<Incidente> incidentesResueltosEspecialidadUltimosNDias(TecnicoService especialidad, int nDias) {
     return null;    
    }
}
