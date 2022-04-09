package com.sid.microservicebanque;

//Déployer servlet Jersey

import com.sid.microservicebanque.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);  //Jersey va prend web service CompteRestJaxRSAPI
        return jerseyServlet;
    }

}
