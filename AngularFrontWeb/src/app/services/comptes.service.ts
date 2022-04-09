import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {KeycloakSecurityService} from "./keycloak-security.service";

@Injectable({
  providedIn: 'root'
})
export class ComptesService {

  constructor(private http: HttpClient,
              private securityService: KeycloakSecurityService) { }

  public getComptes(){
    return this.http.get("http://localhost:8081/banque/comptes");
    // {headers: new HttpHeaders({Authorization:'Bearer '+this.securityService.kc.token}
    //      )},);
  }

}
