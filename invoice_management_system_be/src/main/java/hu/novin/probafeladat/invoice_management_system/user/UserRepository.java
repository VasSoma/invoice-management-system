package hu.novin.probafeladat.invoice_management_system.user;

import hu.novin.probafeladat.invoice_management_system.role.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User getUserByUsername(String username) {
        String jpql = "SELECT u FROM User u WHERE u.username = :userName";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userName", username);
        return query.getSingleResult();
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void removeUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }

    public List<Role> getUserRoles(Long userId) {
        String jpql = "SELECT r FROM User u JOIN u.roles r WHERE u.id = :userId";
        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
