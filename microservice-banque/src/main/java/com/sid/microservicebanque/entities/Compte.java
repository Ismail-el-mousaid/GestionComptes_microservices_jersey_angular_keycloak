package com.sid.microservicebanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)  //utiliser date au lieu datetime
    private Date dateCreation;
    @Enumerated(EnumType.ORDINAL)  //attribut type sera de type numérique (0,1)
    private TypeCompte type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
}
