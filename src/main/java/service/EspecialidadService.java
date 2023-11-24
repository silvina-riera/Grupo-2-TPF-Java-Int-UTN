
package service;

import java.util.List;
import modelos.Especialidad;
import repository.EspecialidadRepository;

public class EspecialidadService {
    
    private final EspecialidadRepository repository = new EspecialidadRepository();
    
    public void crearEspecialidad(Especialidad esp){
       repository.saveEspecialidad(esp);
    }
    
    public Especialidad buscarporId(int id){
        return repository.findEspecialidadPorId(id);
    }
    
     public Especialidad findEspecialidadByNombre(String nombre) {
         return repository.findEspecialidadByNombre(nombre);
     }
    
    public List<Especialidad> findAll(){
        return repository.findAllEspecialidades();
    }
    
    public void modificarEspecialidad(Especialidad esp){
        repository.updateEspecialidad(esp);
    }
    
    public void delete(Especialidad esp){
        repository.deleteEspecialidad(esp);
    }
}
