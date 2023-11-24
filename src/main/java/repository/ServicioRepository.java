
package repository;


import modelos.Servicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ServicioRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveServicio(Servicio servicio){
        tx.begin();
        em.persist(servicio);
        tx.commit();
    }
    
    public Servicio findServicioPorId(int id){
        Servicio encontrado = em.find(Servicio.class, id);
        return encontrado;
    }
    
     public Servicio findServicioByDescripcion(String descripcion) {
        String jpql = "from Servicio s where s.descripcion = :descripcion";
        Query query = em.createQuery(jpql);
        query.setParameter("descripcion", descripcion);
        Servicio encontrado = (Servicio) query.getSingleResult();
        return encontrado;
    }
     
        public List<Servicio> findAllServicios(){
        String jpql = "select s from Servicio s";
        List<Servicio> especialidades = em.createQuery(jpql).getResultList();
        return especialidades;
    }
    
    public void updateServicio(Servicio servicio){
        tx.begin();
        em.merge(servicio);
        tx.commit();
    }
    
    public void deleteServicio(Servicio servicio){
        tx.begin();
        em.remove(em.merge(servicio));
        tx.commit();
    } 
    
}
