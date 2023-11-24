
package repository;

import modelos.Operador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class OperadorRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveOperador(Operador operador){
        tx.begin();
        em.persist(operador);
        tx.commit();
    }
    
    public Operador findOperadorPorId(int id){
        Operador encontrado = em.find(Operador.class, id);
        return encontrado;
    }
     
        public List<Operador> findAllOperadores(){
        String jpql = "select e from Especialidad e";
        List<Operador> especialidades = em.createQuery(jpql).getResultList();
        return especialidades;
    }
    
    public void updateOperador(Operador operador){
        tx.begin();
        em.merge(operador);
        tx.commit();
    }
    
    public void deleteOperador(Operador operador){
        tx.begin();
        em.remove(em.merge(operador));
        tx.commit();
    } 
}
