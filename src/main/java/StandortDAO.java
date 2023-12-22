
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class StandortDAO {
    
        private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ghostNetFishing");
        
        
        public void add(Standort standort){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.persist(standort);
            entityTransaction.commit();
            
        entityManager.close();
    }
}
