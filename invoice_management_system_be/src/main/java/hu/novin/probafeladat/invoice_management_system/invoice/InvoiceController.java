package hu.novin.probafeladat.invoice_management_system.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoice(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/getAllInvoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @PostMapping("createInvoice")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeInvoice/{id}")
    public ResponseEntity<Void> removeInvoice(@PathVariable Long id) {
        invoiceService.removeInvoice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
