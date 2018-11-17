import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../../model/user";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  head=new HttpHeaders();
  constructor(private http: HttpClient,private router: Router) {}

   authenticate(credentials) {
    let headers = new HttpHeaders();
 headers=headers.append('Content-Type', 'application/json');
 headers=headers.append("Authorization", "Basic " + btoa(credentials.username + ':' + credentials.password));
 this.head=headers;
 alert(this.head.getAll("Authorization"));
this.http.post('http://localhost:8081/token',{
    username: credentials.username,
    password: credentials.password,
    role: credentials.role,
    id: credentials.id
},{headers:this.head}).subscribe((data:User) => {
localStorage.setItem('user',data.username);
localStorage.setItem('role',data.role);
  this.router.navigate(['/table']);
      })}
}
