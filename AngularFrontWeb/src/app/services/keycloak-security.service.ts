import { Injectable } from '@angular/core';
import {KeycloakInstance} from "keycloak-js";

declare var Keycloak:any;

@Injectable({
  providedIn: 'root'
})

//Objectif de ce service: démarrer Keycloak avant m que l'application démarre
export class KeycloakSecurityService {
  public kc: any;

  constructor() { }

  async init(){
    console.log("Initialiser Keycloak...");
    this.kc=new Keycloak({
      url:"http://localhost:8080/auth",
      realm:"my-banque-realm",
      clientId:"AngularBanqueApp"
    });
    await this.kc.init({
      //onLoad:'login-required'
      onLoad:'check-sso',
      promiseType:'native'
    });
    console.log(this.kc.token);
  }

}
