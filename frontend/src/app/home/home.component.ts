import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../service/project/project.service";
import {Router} from "@angular/router";
import {TaskService} from "../service/task/task.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalService} from "ngx-bootstrap";
import {Project} from "../model/project";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  projects: Project[];
  user: String = localStorage.getItem('user');

  constructor(private projectServic: ProjectService,
              private router: Router,
              private taskService: TaskService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              ) {
  }
  bsValue = new Date();
  bsRangeValue: Date[];
  maxDate = new Date();

  ngOnInit() {
    this.maxDate.setDate(this.maxDate.getDate() + 7);
      this.bsRangeValue = [this.bsValue, this.maxDate];
  }

}
