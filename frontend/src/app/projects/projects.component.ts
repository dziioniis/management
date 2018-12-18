import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../service/project/project.service";
import {Project} from "../model/project";
import {Router} from "@angular/router";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  user: String = localStorage.getItem('user');
  page: number = 0;
  pages: Array<number>;
  projects: Project[];

  constructor(private router: Router,
              private projectService: ProjectService) {
  }

  getProjects() {
    this.projectService.getProjects(this.page).subscribe(data => {
      this.projects = data['content'];
      this.pages = new Array(data['totalPages']);
    })
  }

  setNext() {
    if (this.page < this.pages.length - 1) {
      this.page = this.page + 1;
    } else {
      this.page = 0;
    }
    this.getProjects()
  }

  setPrev() {
    if (this.page == 0) {
      this.page = this.pages.length - 1;
    } else {
      this.page = this.page - 1
    }
    this.getProjects()
  }


  ngOnInit() {
    if ((localStorage.getItem('user') == null)) {
      this.router.navigate(['home']);
    }
    this.getProjects();
  }

  setProject(project: Project) {
    this.projectService.currentProject = project;
  }

  refreshProjects() {
    this.getProjects();
  }

}
