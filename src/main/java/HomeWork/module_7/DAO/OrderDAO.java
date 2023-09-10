package HomeWork.module_7.DAO;

import HomeWork.module_7.Models.Order;
import HomeWork.module_7.Models.User;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class OrderDAO {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Order order) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(order);
        entityTransaction.commit();
        entityManager.close();
    }

}
