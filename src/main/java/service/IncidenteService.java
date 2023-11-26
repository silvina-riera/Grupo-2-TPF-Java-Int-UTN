package service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import modelos.Incidente;
import modelos.TipoProblema;
import repository.IncidenteRepository;

public class IncidenteService {

    private final IncidenteRepository repository = new IncidenteRepository();

    public void crearIncidente(Incidente incidente) {
        repository.saveIncidente(incidente);
    }

    public Incidente buscarporId(int id) {
        return repository.findIncidentePorId(id);
    }

    public List<Incidente> findAll() {
        return repository.findAllIncidentes();
    }

    public void modificarIncidente(Incidente incidente) {
        repository.updateIncidente(incidente);
    }

    public void delete(Incidente incidente) {
        repository.deleteIncidente(incidente);
    }

    public int sumarTiempoEstimado(Set<TipoProblema> problemas) {
        return problemas.stream().mapToInt(TipoProblema::getTiempoEstimado).sum();
    }

    //Metodos para consultas solicitadas en el TPF entrega 2
    public List<Incidente> listarPorXDias(int nDias) {
        List<Incidente> incidentesNDias = findAll().stream()
                .filter(incidente -> incidente.getTiempoResolucion() <= nDias)
                .collect(Collectors.toList());

        return incidentesNDias;
    }
    
     
}
