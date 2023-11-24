
package service;

import java.util.List;
import modelos.Servicio;
import repository.ServicioRepository;


public class ServicioService {
    
    private final ServicioRepository repository = new ServicioRepository();
    
    public void crearServicio(Servicio servicio){
        repository.saveServicio(servicio);
    }
    
    public Servicio buscarporId(int id){
        return repository.findServicioPorId(id);
    }
    
    public Servicio buscarporDescripcion(String descripcion){
        return repository.findServicioByDescripcion(descripcion);
    }
    
    public List<Servicio> findAll(){
        return repository.findAllServicios();
    }

    
    public void modificarServicio(Servicio servicio){
        repository.updateServicio(servicio);
    }
    
    public void delete(Servicio servicio){
        repository.deleteServicio(servicio);
    }
}
