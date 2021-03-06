import {Component, OnInit} from '@angular/core';
import {KeycloakSecurityService} from "./services/keycloak-security.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(public securityService: KeycloakSecurityService) {

  }

  ngOnInit(): void {
        throw new Error('Method not implemented.');
    }

  title = 'AngularFrontWeb';

  onLogout() {
    this.securityService.kc.logout();
  }

  onLogin() {
    this.securityService.kc.login();
  }

  onChangePassword() {
    this.securityService.kc.accountManagement();
  }

  isRoleManager() {
    return this.securityService.kc.hasRealmRole('MANAGER');
  }
}
