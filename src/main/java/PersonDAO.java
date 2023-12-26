
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class PersonDAO {
    
        private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ghostNetFishing");
        
        
        public void add(Person person){
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            EntityTransaction entityTransaction = entityManager.getTransaction();
                
            entityTransaction.begin();
                entityManager.persist(person);
            entityTransaction.commit();
            
        entityManager.close();
    }
}