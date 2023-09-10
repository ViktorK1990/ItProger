package HomeWork.module_7.DAO;

import HomeWork.module_7.Models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserDAO {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
        entityManager.close();
    }

    public void update(int id, User newUser) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, id);
        user.setAge(newUser.getAge());
        user.setUsername(newUser.getUsername());
        user.addOrder(newUser.getLastOrder());
        entityManager.persist(user);
        entityTransaction.commit();
        entityManager.close();
    }

    public void deleteById (int id) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityTransaction.commit();
    }

    public List<User> findByName(String name) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM User i WHERE username = :s";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("s", name);
        return typedQuery.getResultList();
    }

    public List<User> sortByAge (int from, int up_to) {
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM User i WHERE age > :s1 - 1 AND age < :s2";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("s1", from);
        typedQuery.setParameter("s2", up_to);
        return typedQuery.getResultList();
    }

}
