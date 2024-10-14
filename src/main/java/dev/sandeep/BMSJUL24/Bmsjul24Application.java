package dev.sandeep.BMSJUL24;

import dev.sandeep.BMSJUL24.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bmsjul24Application implements CommandLineRunner {

	@Autowired
	private InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(Bmsjul24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("STARTING DATA INITIALIZATION");
		//initService.initialise();
	}
}
