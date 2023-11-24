
package service;

import java.time.LocalDate;
import java.util.List;
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
    
    public Tecnico resueltosporFecha(LocalDate fecha1, LocalDate fecha2) {
       List<Tecnico> tecnicos = repository.obtenerResueltosPorFecha(fecha1, fecha2);
        System.out.println("Lista tecnicos :" + tecnicos);
       Tecnico tecnicoMasResultos = tecnicos.get(0);
       return tecnicoMasResultos;
    }
}
