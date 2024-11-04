package hu.novin.probafeladat.invoice_management_system.invoice;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "issue_date")
    private Timestamp issueDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "total_amount")
    private String totalAmount;

    public Invoice() {
    }

    public Invoice(Long id, String customerName, Timestamp issueDate, Timestamp dueDate,
                   String itemName, String description, String totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.itemName = itemName;
        this.description = description;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
