
package repository;

import java.time.LocalDate;
import modelos.Tecnico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelos.EEstado;
import modelos.Incidente;

public class TecnicoRepository {
    
    EntityManager em = EntityManagerConfig.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public void saveTecnico(Tecnico tecnico){
        tx.begin();
        em.persist(tecnico);
        tx.commit();
    }
    
    public Tecnico findTecnicoPorId(int id){
        Tecnico encontrado = em.find(Tecnico.class, id);
        return encontrado;
    }
    
    public Tecnico findTecnicoByApellido(String apellido) {
        String jpql ="SELECT t FROM Tecnico t WHERE t.apellido = :apellido";
        Tecnico tecnico = em.createQuery(jpql, Tecnico.class)
        .setParameter("apellido", apellido).getSingleResult();
        return tecnico;
    }
    
    public List<Tecnico> findAllTecnicos(){
        String jpql = "select o from Tecnico o";
        List<Tecnico> tecnico = em.createQuery(jpql).getResultList();
        return tecnico;
    }
    
    /*
     *TODO: probar la query. 
    */
    public List<Incidente> obtenerResueltosPorFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
        String jpql ="SELECT i FROM Incidente i WHERE i.fechaCreacion>= :fecha1 AND i.fechaCierre <= :fecha2"
                + " AND i.estado = :estado";        
        List<Incidente> incidentes = em.createQuery(jpql, Incidente.class)
        .setParameter("estado", EEstado.RESUELTO)
        .setParameter("fecha1", fecha1).setParameter("fecha2", fecha2).getResultList();
        return incidentes;
    }
    
    public void updateTecnico(Tecnico tecnico){
        tx.begin();
        em.merge(tecnico);
        tx.commit();
    }
    
    public void delete(Tecnico tecnico){
        tx.begin();
        em.remove(em.merge(tecnico));
        tx.commit();
    }
}
