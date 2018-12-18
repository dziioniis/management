import { Component, OnInit,TemplateRef } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Task} from "../model/task";
import {User} from "../model/user";
import {Project} from "../model/project";
import {TaskService} from "../service/task/task.service";
import {ProjectService} from "../service/project/project.service";
import {UserService} from "../service/user/user.service";



@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
projects:Project[];
users:User[];
  date = new Date();
  minDate=this.date.setDate((new Date()).getDate());



 public editMode = false;
 public modalRef: BsModalRef;
 public editableBa: Task = new Task();
 private subscriptions: Subscription[] = [];
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private taskService:TaskService,
              private projectService:ProjectService,
              private userService:UserService,
  ) { }

  ngOnInit() {
    this.loadUsers();
      this.loadProjects()
  }
public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }
  public _addTask(): void {
    this.loadingService.show();
    this.editableBa.reporter=localStorage.getItem('user');
    this.subscriptions.push(this.taskService.saveTask(this.editableBa).subscribe(() => {
      this._closeModal();
      this.refreshBa();
      this.loadingService.hide();
 window.location.reload();
    }));
  }
 public _closeModal(): void {
    this.modalRef.hide();
  }
private refreshBa(): void {
    this.editableBa = new Task();
  }
  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
loadUsers():void{
this.loadingService.show();
this.subscriptions.push(this.userService.getUsers().subscribe(data=>{
this.users=data as User[];
this.loadingService.hide();
}));
}

loadProjects():void{
this.loadingService.show();
    this.subscriptions.push(this.projectService.getProjectsAll().subscribe(data => {
      this.projects=data as Project[];
      this.loadingService.hide();
    }));
}
}
