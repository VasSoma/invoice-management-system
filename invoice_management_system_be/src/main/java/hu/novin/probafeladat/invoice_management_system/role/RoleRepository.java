package hu.novin.probafeladat.invoice_management_system.role;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    private final EntityManager entityManager;

    @Autowired
    public RoleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    public List<Role> getAllRoles() {
        TypedQuery<Role> query = entityManager.createQuery("FROM Role", Role.class);
        return query.getResultList();
    }
}
