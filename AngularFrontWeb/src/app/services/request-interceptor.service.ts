import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {KeycloakSecurityService} from "./keycloak-security.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RequestInterceptorService implements HttpInterceptor{

  constructor(private securityService: KeycloakSecurityService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("Request Http Interceptor...");
    if(!this.securityService.kc.authenticated) return next.handle(req);
    let request=req.clone({
      setHeaders:{
        Authorization:'Bearer '+this.securityService.kc.token
      }
    });
    return next.handle(request);
  }


}
