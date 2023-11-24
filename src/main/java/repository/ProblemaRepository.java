
package repository;


import modelos.TipoProblema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class ProblemaRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveProblema(TipoProblema problema){
        tx.begin();
        em.persist(problema);
        tx.commit();
    }
    
    public TipoProblema findTipoProblemaPorId(int id){
        TipoProblema encontrado = em.find(TipoProblema.class, id);
        return encontrado;
    }
     
        public List<TipoProblema> findAllProblemas(){
        String jpql = "select s from TipoProblema t";
        List<TipoProblema> problemas = em.createQuery(jpql).getResultList();
        return problemas;
    }
    
    public void updateProblema(TipoProblema problema){
        tx.begin();
        em.merge(problema);
        tx.commit();
    }
    
    public void deleteProblema(TipoProblema problema){
        tx.begin();
        em.remove(em.merge(problema));
        tx.commit();
    } 
}
