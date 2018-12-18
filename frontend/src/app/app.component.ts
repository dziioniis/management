import { Component,OnInit } from '@angular/core';
import { LoginService } from './service/login/login.service';
import {User} from "./model/user";
import {Router} from '@angular/router';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
constructor(private loginService:LoginService,private router: Router){
}
current=localStorage.getItem('user');
role=localStorage.getItem('role');

  public title = 'management'
 ngOnInit(): void {
  }

}

