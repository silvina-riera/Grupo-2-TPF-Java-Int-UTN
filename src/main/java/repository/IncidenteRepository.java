
package repository;

import modelos.Incidente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class IncidenteRepository {

    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    
     public void saveIncidente(Incidente incidente){
        tx.begin();
        em.persist(incidente);
        tx.commit();
    }
    
    public Incidente findIncidentePorId(int id){
        Incidente encontrado = em.find(Incidente.class, id);
        return encontrado;
    }
    
     public Incidente findIncidenteByFechaCreacion(Incidente incidente) {
        String jpql = "from Incidente i where i.fechaCreacion = :fechaCreacion";
        Query query = em.createQuery(jpql);
        query.setParameter("fechaCreacion", incidente.getFechaCreacion());
        Incidente encontrado = (Incidente) query.getSingleResult();
        return encontrado;
    }
     
     public Incidente findIncidenteByFechaCierre(Incidente incidente) {
        String jpql = "from Incidente i where i.fechaCierre = :fechaCierre";
        Query query = em.createQuery(jpql);
        query.setParameter("fechaCierre", incidente.getFechaCierre());
        Incidente encontrado = (Incidente) query.getSingleResult();
        return encontrado;
    } 
     
        public List<Incidente> findAllIncidentes(){
        String jpql = "select i from Incidente i";
        List<Incidente> incidentes = em.createQuery(jpql).getResultList();
        return incidentes;
    }
    
    public void updateIncidente(Incidente incidente){
        tx.begin();
        em.merge(incidente);
        tx.commit();
    }
    
    public void deleteIncidente(Incidente incidente){
        tx.begin();
        em.remove(em.merge(incidente));
        tx.commit();
    } 
}
