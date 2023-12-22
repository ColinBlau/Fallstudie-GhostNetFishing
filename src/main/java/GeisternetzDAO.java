
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GeisternetzDAO {
    
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ghostNetFishing");
    
    
    public List<Geisternetz> findeGemeldete(){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query abfrage = entityManager.createQuery("select a from Geisternetz a where a.status = :GEMELDET");
            abfrage.setParameter("GEMELDET", NetzStatus.GEMELDET);
            List<Geisternetz> alleNetze = abfrage.getResultList();
        entityManager.close();
        
        return alleNetze;
    }
    
    public List<Geisternetz> findeZuBergende(){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query abfrage = entityManager.createQuery("select a from Geisternetz a where a.status = :BERGUNG_BEVORSTEHEND");
            abfrage.setParameter("BERGUNG_BEVORSTEHEND", NetzStatus.BERGUNG_BEVORSTEHEND);
            List<Geisternetz> alleNetze = abfrage.getResultList();
        entityManager.close();
        
        return alleNetze;
    }
    
    public void add(Geisternetz geisternetz){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.persist(geisternetz);
            entityTransaction.commit();
            
        entityManager.close();
    }
}