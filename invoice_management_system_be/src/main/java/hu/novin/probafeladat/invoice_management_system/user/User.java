package hu.novin.probafeladat.invoice_management_system.user;

import hu.novin.probafeladat.invoice_management_system.role.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="entry_date")
    private LocalDate entryDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String username, String password, Set<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.entryDate = LocalDate.now();
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }

}
