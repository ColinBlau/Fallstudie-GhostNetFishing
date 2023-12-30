
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Geisternetz Data Access Object:
 * Kapselt in sich alle Zugriffsfunktionen auf die Datenbank,
 * die sich direkt auf Geisternetz-Instanzen beziehen.
 * @author colin
 */
public class GeisternetzDAO {
    
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ghostNetFishing");
    
    
    /**
     * Gibt ein Liste an allen <code>Geisternetz</code>-Instanzen der Datenbank aus, deren <code>NetzStatus</code>-Attribut <code>GEMELDET</code> aufweisen.
     * @return      Liste an allen <code>Geisternetz</code>-Instanzen deren <code>NetzStatus</code>-Attribut <code>GEMELDET</code> aufweisen.
     */
    public List<Geisternetz> findeGemeldete(){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query abfrage = entityManager.createQuery("select a from Geisternetz a where a.status = :GEMELDET");
            abfrage.setParameter("GEMELDET", NetzStatus.GEMELDET);
            List<Geisternetz> alleNetze = abfrage.getResultList();
        entityManager.close();
        
        return alleNetze;
    }
    
    /**
     * Gibt ein Liste an allen <code>Geisternetz</code>-Instanzen der Datenbank aus, deren <code>NetzStatus</code>-Attribut <code>BERGUNG_BEVORSTEHEND</code> aufweisen.
     * @return      Liste an allen <code>Geisternetz</code>-Instanzen deren <code>NetzStatus</code>-Attribut <code>BERGUNG_BEVORSTEHEND</code> aufweisen.
     */
    public List<Geisternetz> findeZuBergende(){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query abfrage = entityManager.createQuery("select a from Geisternetz a where a.status = :BERGUNG_BEVORSTEHEND");
            abfrage.setParameter("BERGUNG_BEVORSTEHEND", NetzStatus.BERGUNG_BEVORSTEHEND);
            List<Geisternetz> alleNetze = abfrage.getResultList();
        entityManager.close();
        
        return alleNetze;
    }
    
    /**
     * Persistiert ein neues <code>Geisternetz</code>-Objekt in die Datenbank.
     * Es wird ein neuer Eintrag in der Datenbank angelegt. 
     * Besteht das Objekt bereits bzw. wurde die <code>id</code> bereits vergeben, wird eine Exception von der Datenbank geworfen.
     * @param geisternetz       das zu persisitierende <code>Geisternetz</code>-Objekt
     */
    public void add(Geisternetz geisternetz){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.persist(geisternetz);
            entityTransaction.commit();
            
        entityManager.close();
    }
    
    /**
     * Persistiert das durchgegebene <code>Geisternetz</code>-Objekt in der Datenbank.
     * Ein eventuelles altes, in der Datenbank vorhandene Objekte, wird vom neuen Objekt überschrieben.
     * @param geisternetz       das zu persisitierende <code>Geisternetz</code>-Objekt
     */
    public void save(Geisternetz geisternetz){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.merge(geisternetz);
            entityTransaction.commit();
            
        entityManager.close();
    }
}