
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Standort Data Access Object:
 * Kapselt in sich alle Zugriffsfunktionen auf die Datenbank,
 * die sich direkt auf Standort-Instanzen beziehen.
 * @author colin
 */
public class StandortDAO {
    
        private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ghostNetFishing");
        
        /**
         * Persistiert ein neues <code>Standort</code>-Objekt in die Datenbank.
         * @param standort  das zu persistierende <code>Standort</code>-Objekt
         */
        public void add(Standort standort){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.persist(standort);
            entityTransaction.commit();
            
        entityManager.close();
    }
}
