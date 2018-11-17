import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {LoginService} from "../service/login/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
credentials = {username: '', password: '',role:"",id:""};
authenticated:boolean=false;


constructor( private loginService:LoginService, private http: HttpClient, private router: Router) {}

public login():void {
    this.credentials.role="admin";
    this.credentials.id="123";
    this.loginService.authenticate(this.credentials);
  }
  ngOnInit() {
  if(localStorage.getItem("user")){
    this.router.navigate(['/table'])
  }
  }
}
