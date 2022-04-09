package com.sid.microservicebanque.web;

//Web Service REST (Jersey 'JaxRS')

import com.sid.microservicebanque.entities.Compte;
import com.sid.microservicebanque.entities.TypeCompte;
import com.sid.microservicebanque.repository.CompteRepository;
import com.sid.microservicebanque.service.IBanqueService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    @Autowired
    private IBanqueService banqueService;

    @Path("/comptes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> compteList(){
        return banqueService.getComptes();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Compte compte(@PathParam(value = "id") Long id){
        return banqueService.getCompte(id);
    }

    @Path("/comptes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Compte save(Compte compte){
        return banqueService.saveCompte(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update(@PathParam("id") Long id, Compte compte){
        return banqueService.updateCompte(id, compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        banqueService.deleteCompte(id);
    }

    @Path("/comptes/type={type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> findByTypeCompte(@PathParam("type") TypeCompte type){
        return banqueService.getComptesByType(type);
    }

    //Get JWT
  /*  @Path("/jwt")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> map(HttpServletRequest request){
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
        Map<String, String> map = new HashMap<>();
        map.put("access_token", keycloakSecurityContext.getTokenString());
        return map;
    }  */

}

