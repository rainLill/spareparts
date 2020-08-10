package ee.rlservice.spareparts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparepartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparepartsApplication.class, args);
	}

}

//TODO: Create login
//TODO: Add to cookie CSRF key
//TODO: Generate fail from results
//TODO: Generate email with automated database request
//TODO: Run automated database request
