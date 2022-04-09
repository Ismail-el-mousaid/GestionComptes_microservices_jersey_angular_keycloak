package com.sid.microservicebanque.repository;

import com.sid.microservicebanque.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
