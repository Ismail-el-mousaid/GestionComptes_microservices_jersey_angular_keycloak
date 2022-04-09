import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompteComponent } from './compte/compte.component';
import {KeycloakSecurityService} from "./services/keycloak-security.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RequestInterceptorService} from "./services/request-interceptor.service";

function kcFactory(kcSecurity: KeycloakSecurityService) {
  return ()=> kcSecurity.init();
}

@NgModule({
  declarations: [
    AppComponent,
    CompteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    {provide:APP_INITIALIZER, deps:[KeycloakSecurityService], useFactory:kcFactory,multi:true},
    {provide: HTTP_INTERCEPTORS, useClass: RequestInterceptorService, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
