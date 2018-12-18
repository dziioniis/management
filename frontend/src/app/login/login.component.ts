import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {LoginService} from "../service/login/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error:any;
  credentials = {username: '', password: '', role: "", id: ""};


  constructor(private loginService: LoginService, private http: HttpClient, private router: Router) {
  }

  public login(): void {
    this.loginService.authenticate(this.credentials);
    this.error=localStorage.getItem('error');
  }


  ngOnInit() {
  }

}
