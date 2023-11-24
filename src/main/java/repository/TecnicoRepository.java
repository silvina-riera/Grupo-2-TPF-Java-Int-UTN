
package repository;

import java.time.LocalDate;
import modelos.Tecnico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
        System.out.println("Cliente encontrado: " + encontrado);
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
    
    public List<Tecnico> obtenerResueltosPorFecha(LocalDate fecha1, LocalDate fecha2) {
        String jpql ="SELECT t.nombre, t.apellido COUNT(i.id) AS cant_resueltos FROM Tecnico t " +
                 "JOIN t.incidentes i WHERE i.estado = Resuelto AND i.fechaCierre BETWEEN :fecha1 AND :fecha2 " +
                 "GROUP BY t.apellido ORDER BY cant_resueltos DESC";
        List<Tecnico> tecnicos = em.createQuery(jpql, Tecnico.class)
        .setParameter("fecha1", fecha1).setParameter("fecha2", fecha2).getResultList();
        return tecnicos;
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
