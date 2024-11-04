package hu.novin.probafeladat.invoice_management_system.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }
}
