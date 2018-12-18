import {Injectable} from '@angular/core';
import {HttpClient, HttpBackend} from '@angular/common/http';
import {User} from "../../model/user";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {JwtHelperService} from '@auth0/angular-jwt';
const helper = new JwtHelperService();


@Injectable({
  providedIn: 'root'
})

export class LoginService {
  constructor(private http: HttpClient, private router: Router, private handler: HttpBackend) {
  }
  loggedIn:boolean=false;

  authenticate(credentials) {
    this.http.post('http://localhost:8081/token', {
      username: credentials.username,
      password: credentials.password
    }).subscribe((data: User) => {
      if(data==null){
        alert("The username and password that you entered did not match.Please double-check and try again.");
      }else {
        localStorage.setItem('user', data.username);
        localStorage.setItem('id', String(data.id));
        localStorage.setItem('role', data.role);
        localStorage.setItem('mail', data.email);
        localStorage.setItem('token', data.token);
        localStorage.setItem('refreshToken', data.refreshToken);
        this.loggedIn=true;
        this.router.navigate( ['main']);
        alert("you have " + ((helper.getTokenExpirationDate(data.token).getMinutes()) -new Date().getMinutes() + " min"));

      }
    }, error1 => {alert("The username and password that you entered did not match.Please double-check and try again.")}
  )
  }

  logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('role');
    window.location.reload();
  }

  refresh() {
    this.http = new HttpClient(this.handler);
    return this.http.post<User>('http://localhost:8081/token/refresh', {
      refresh: localStorage.getItem("refreshToken"),
      username: localStorage.getItem("user")
    }).subscribe((data: User) => {
      alert("hello");
      localStorage.removeItem('token');
      localStorage.removeItem('refreshToken');
      localStorage.setItem('token', data.token);
      localStorage.setItem('refreshToken', data.refreshToken);
      window.location.reload();

    });
  }
}

