package hu.novin.probafeladat.invoice_management_system;

import hu.novin.probafeladat.invoice_management_system.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoicingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoicingSystemApplication.class, args);
	}
}
