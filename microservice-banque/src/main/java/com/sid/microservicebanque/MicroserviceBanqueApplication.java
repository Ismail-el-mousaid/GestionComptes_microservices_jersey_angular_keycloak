package com.sid.microservicebanque;

import com.sid.microservicebanque.entities.Client;
import com.sid.microservicebanque.entities.Compte;
import com.sid.microservicebanque.entities.TypeCompte;
import com.sid.microservicebanque.repository.ClientRepository;
import com.sid.microservicebanque.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MicroserviceBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository){
		return args -> {
			Client client1 = clientRepository.save(new Client(null, "Ismail",null));
			Client client2 = clientRepository.save(new Client(null, "Mohamed",null));

			compteRepository.save(new Compte(null, Math.random()*1000, new Date(), TypeCompte.COURANT, client1));
			compteRepository.save(new Compte(null, Math.random()*1000, new Date(), TypeCompte.EPARGNE, client1));
			compteRepository.save(new Compte(null, Math.random()*1000, new Date(), TypeCompte.COURANT, client2));
			compteRepository.findAll().forEach(compte -> {
				System.out.println(compte.getSolde());
			});

		};
	}


}
