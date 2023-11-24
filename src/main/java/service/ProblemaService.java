
package service;

import java.util.List;
import modelos.TipoProblema;
import repository.ProblemaRepository;

public class ProblemaService {
    
      private final ProblemaRepository repository = new ProblemaRepository();
    
    public void crearProblema(TipoProblema problema){
        repository.saveProblema(problema);
    }
    
    public TipoProblema buscarporId(int id){
        return repository.findTipoProblemaPorId(id);
    }
    
    public List<TipoProblema> findAll(){
        return repository.findAllProblemas();
    }
    
    public void modificarProblema(TipoProblema problema){
        repository.updateProblema(problema);
    }
    
    public void delete(TipoProblema problema){
        repository.deleteProblema(problema);
    }
}
