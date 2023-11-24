
package repository;

import modelos.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ClienteRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveCliente(Cliente cliente){
        tx.begin();
        em.persist(cliente);
        tx.commit();
    }
    
    public Cliente findClientePorId(int id){
        Cliente encontrado = em.find(Cliente.class, id);
        return encontrado;
    }
    
    
    public Cliente findClienteByRazonSocial(String razonSocial) {
        String jpql = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial";
        Query query = em.createQuery(jpql);
        query.setParameter("razonSocial", razonSocial);
        Cliente encontrado = (Cliente) query.getSingleResult();
        return encontrado;
    }
    
    public List<Cliente> findAllClientes(){
        String jpql = "select cliente from Cliente cliente";
        List<Cliente> clientes = em.createQuery(jpql).getResultList();
        return clientes;
    }
    
    public void updateCliente(Cliente cliente){
        tx.begin();
        em.merge(cliente);
        tx.commit();
    }
    
    public void delete(Cliente cliente){
        tx.begin();
        em.remove(em.merge(cliente));
        tx.commit();
    }
}
