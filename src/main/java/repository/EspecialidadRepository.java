
package repository;

import modelos.Especialidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class EspecialidadRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveEspecialidad(Especialidad esp){
        tx.begin();
        em.persist(esp);
        tx.commit();
    }
    
    public Especialidad findEspecialidadPorId(int id){
        Especialidad encontrado = em.find(Especialidad.class, id);
        return encontrado;
    }
    
     public Especialidad findEspecialidadByNombre(String nombre) {
        String jpql = "from Especialidad e where e.nombre = :nombre";
        Query query = em.createQuery(jpql);
        query.setParameter("nombre", nombre);
        Especialidad encontrado = (Especialidad) query.getSingleResult();
        return encontrado;
    }
     
        public List<Especialidad> findAllEspecialidades(){
        String jpql = "select e from Especialidad e";
        List<Especialidad> especialidades = em.createQuery(jpql).getResultList();
        return especialidades;
    }
    
    public void updateEspecialidad(Especialidad esp){
        tx.begin();
        em.merge(esp);
        tx.commit();
    }
    
    public void deleteEspecialidad(Especialidad esp){
        tx.begin();
        em.remove(em.merge(esp));
        tx.commit();
    } 
}
