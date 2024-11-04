package hu.novin.probafeladat.invoice_management_system.enums;

public enum RoleType {

    ADMINISTRATOR("Administrator has the authorization to see all pages."),

    ACCOUNTANT("Accountant has the authorization to create invoices and see all invoices. Can't see the admin page."),

    STANDARD_USER("Standard user has the authorization to see all invoices.");

    public final String description;

    RoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
