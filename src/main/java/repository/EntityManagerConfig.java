
package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerConfig {

    public static EntityManager getEntityManager(){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabajoPracticoFinal_PU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}
