import { Component, OnInit } from '@angular/core';
import {NewProjectComponent} from "../new-project/new-project.component";
import {NewTaskComponent} from "../new-task/new-task.component";
import {NewUserComponent} from "../new-user/new-user.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-top-label',
  templateUrl: './top-label.component.html',
  styleUrls: ['./top-label.component.css']
})
export class TopLabelComponent implements OnInit {
  role=localStorage.getItem('role');

  constructor(private router:Router) { }

  ngOnInit() {
  }
  logout():void{
    localStorage.removeItem('user');
    this.router.navigate(['']);
  }

}
