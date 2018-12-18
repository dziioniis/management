import {Injectable} from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor} from '@angular/common/http';
import {Observable} from "rxjs";
import {JwtHelperService} from '@auth0/angular-jwt';
import {LoginService} from "../login/login.service";
const helper = new JwtHelperService();
@Injectable({
  providedIn: 'root'
})


export class JwtInteceptorService implements HttpInterceptor {
  constructor(private loginService: LoginService) {
  }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = localStorage.getItem('token');
    if(token) {
      if (helper.isTokenExpired(token)) {
        if (confirm("session is over,do you want continue?")) {
          this.loginService.refresh();
        } else {
          this.loginService.logout();
        }
      }
      req = req.clone({
        setHeaders: {
          Authorization: `Token ${token}`
        }
      });
    }
    return next.handle(req);
  }
}
