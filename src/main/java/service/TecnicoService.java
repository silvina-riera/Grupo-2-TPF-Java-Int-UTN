
package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelos.EEstado;
import modelos.Incidente;
import modelos.Tecnico;
import repository.TecnicoRepository;

public class TecnicoService {
    
    private final TecnicoRepository repository = new TecnicoRepository();
    
    public void crearTecnico(Tecnico tecnico){
        repository.saveTecnico(tecnico);
    }
    
    public Tecnico buscarporId(int id){
        return repository.findTecnicoPorId(id);
    }
    
    public List<Tecnico> findAll(){
        return repository.findAllTecnicos();
    }
    
    public void modificarTecnicos(Tecnico tecnico){
        repository.updateTecnico(tecnico);
    }
    
    public void delete(Tecnico tecnico){
        repository.delete(tecnico);
    }
    
    public Tecnico resueltosporFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
       List<Incidente> incidentes = repository.obtenerResueltosPorFecha(estado, fecha1, fecha2);
       Map<Tecnico, Long> resueltos = incidentes.stream().collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
       Tecnico tecnicoConMasIncidentes = resueltos.entrySet().stream()
       .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
       return tecnicoConMasIncidentes;
    }
}
