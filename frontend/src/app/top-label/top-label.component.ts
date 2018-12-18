import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../service/login/login.service";

@Component({
  selector: 'app-top-label',
  templateUrl: './top-label.component.html',
  styleUrls: ['./top-label.component.css']
})
export class TopLabelComponent implements OnInit {
  role=localStorage.getItem('role');

  constructor(private router:Router,private loginService:LoginService) { }

  ngOnInit() {
  }
  logout():void{
   this.loginService.logout();
  }

}
