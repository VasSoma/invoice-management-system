package hu.novin.probafeladat.invoice_management_system.invoice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepository {

    private final EntityManager entityManager;

    @Autowired
    public InvoiceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Invoice getInvoice(Long id) {
        return entityManager.find(Invoice.class, id);
    }

    public List<Invoice> getAllInvoices() {
        TypedQuery<Invoice> query = entityManager.createQuery("FROM Invoice", Invoice.class);
        return query.getResultList();
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        entityManager.persist(invoice);
        return invoice;
    }

    public void removeInvoice(Long id) {
        Invoice invoice = entityManager.find(Invoice.class, id);
    }


}
