import {Component, OnInit, TemplateRef, Input} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {User} from "../model/user";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../service/user/user.service";
import {Project} from "../model/project";
import {ProjectService} from "../service/project/project.service";
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  @Input() public project: Project;
  public modalRef: BsModalRef;
  public editableBa: User = new User();
  private subscriptions: Subscription[] = [];
  public task: Task[];
  private role=localStorage.getItem('role');

  constructor( private router: Router,
    private taskService: TaskService,
              private projectService: ProjectService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private userService: UserService) {
  }

  ngOnInit() {
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
    this.loadTasks();
  }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  loadTasks() {
    this.taskService.getTaskByProjectCode(this.project.code).subscribe(data => {
      this.task = data as Task[];
    })
  }

  setTask(task: Task) {
    this.taskService.currentTask = task;
    this.router.navigate(['task']);
    this._closeModal();
  }

  private refreshBa(): void {
    this.editableBa = new User();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

