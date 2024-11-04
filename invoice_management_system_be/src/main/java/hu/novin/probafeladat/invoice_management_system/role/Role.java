package hu.novin.probafeladat.invoice_management_system.role;

import hu.novin.probafeladat.invoice_management_system.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
        this.description = RoleType.valueOf(name.toUpperCase()).getDescription();
    }

    public Role(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleType getRoleType() {
        return RoleType.valueOf(this.name);
    }
}
