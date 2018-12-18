import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Project} from "../model/project";
import {ProjectService} from "../service/project/project.service";
import {ProjectsComponent} from "../projects/projects.component";


@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  public projects: Project[];
  public editMode = false;
  public modalRef: BsModalRef;
  public editableBa: Project = new Project();
  private subscriptions: Subscription[] = [];

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private projectService: ProjectService,
  ) {
  }

  ngOnInit() {
  }

  public _openModal(template: TemplateRef<any>): void {
    this.loadProjects();
    this.modalRef = this.modalService.show(template);
  }

  public _addProject(): void {
    this.loadingService.show();
    this.editableBa.author = localStorage.getItem('user');
    this.subscriptions.push(this.projectService.saveProject(this.editableBa).subscribe( data => {
      if(data==null){
        alert("name is exist.");
      }else{
      this.loadingService.hide();
      this._closeModal();
      this.refreshBa();}
    }));
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  private refreshBa(): void {
    this.editableBa = new Project();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private checkUsername(): boolean {
    for (let a = 0; this.projects.length > 0; a++) {

      let value = this.projects[a].code;
      if (value !== this.editableBa.code) {
        return true;
      }
    }
  }

  getResult(): boolean {
    return this.checkUsername();
  }

  private loadProjects() {
    this.projectService.getProjectsAll().subscribe(data => {
      this.projects = data as Project[];
    })
  }
}



