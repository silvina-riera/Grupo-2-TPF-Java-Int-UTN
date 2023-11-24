
package service;

import java.util.List;
import modelos.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    
    private final ClienteRepository repository = new ClienteRepository();
    
    public void crearCliente(Cliente cliente){
        repository.saveCliente(cliente);
    }
    
    public Cliente buscarporId(int id){
        return repository.findClientePorId(id);
    }
    
    public Cliente findClienteByRazonSocial(String razonSocial) {
        return repository.findClienteByRazonSocial(razonSocial);
    }
    
    public List<Cliente> findAll(){
        return repository.findAllClientes();
    }
    
    public void modificarCliente(Cliente cliente){
        repository.updateCliente(cliente);
    }
    
    public void delete(Cliente cliente){
        repository.delete(cliente);
    }
}
