
package service;

import java.util.List;
import modelos.Operador;
import repository.OperadorRepository;

public class OperadorService {

    private final OperadorRepository repository = new OperadorRepository();
    
    public void crearOperador(Operador op){
        repository.saveOperador(op);
    }
    
    public Operador buscarporId(int id){
        return repository.findOperadorPorId(id);
    }
    
    public List<Operador> findAll(){
        return repository.findAllOperadores();
    }
    
    public void modificarOperador(Operador operador){
        repository.updateOperador(operador);
    }
    
    public void delete(Operador op){
        repository.deleteOperador(op);
    }
    
}
