package hu.novin.probafeladat.invoice_management_system.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice getInvoice(Long id) {
        return invoiceRepository.getInvoice(id);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.getAllInvoices();
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.createInvoice(invoice);
    }

    public void removeInvoice(Long id) {
        invoiceRepository.removeInvoice(id);
    }
}
