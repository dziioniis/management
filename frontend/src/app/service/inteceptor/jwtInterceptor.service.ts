import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class JwtInteceptorService implements HttpInterceptor{

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token=localStorage.getItem('token');
    if(token){
      req=req.clone( { setHeaders: {
        Authorization: `Token ${token}`
      }
    });
    }
    return next.handle(req);
  }

  constructor() { }
}
