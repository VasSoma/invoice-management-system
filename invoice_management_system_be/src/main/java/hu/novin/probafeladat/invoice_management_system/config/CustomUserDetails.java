package hu.novin.probafeladat.invoice_management_system.config;

import hu.novin.probafeladat.invoice_management_system.enums.Permissions;
import hu.novin.probafeladat.invoice_management_system.enums.RoleType;
import hu.novin.probafeladat.invoice_management_system.role.Role;
import hu.novin.probafeladat.invoice_management_system.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> userRoles = user.getRoles();
        for (Role r : userRoles) {
            RoleType roleType = RoleType.valueOf(r.getRoleType().name().toUpperCase());
            if (roleType.equals(RoleType.ADMINISTRATOR)) {
                authorities.add(new SimpleGrantedAuthority(Permissions.VIEW_ADMIN_PAGE.name()));
                authorities.add(new SimpleGrantedAuthority(Permissions.MANAGE_INVOICE.name()));
                authorities.add(new SimpleGrantedAuthority(Permissions.VIEW_INVOICES.name()));
            } else if (roleType.equals(RoleType.ACCOUNTANT)) {
                authorities.add(new SimpleGrantedAuthority(Permissions.MANAGE_INVOICE.name()));
                authorities.add(new SimpleGrantedAuthority(Permissions.VIEW_INVOICES.name()));
            } else {
                authorities.add(new SimpleGrantedAuthority(Permissions.VIEW_INVOICES.name()));
            }
        }
        System.out.println("User authorities: " + authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // Omitting the implementation of the following methods for simplicity
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
