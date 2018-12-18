import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {User} from "../model/user";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../service/user/user.service";
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  task: Task[];
  public editMode = false;
  public modalRef: BsModalRef;
  public role = localStorage.getItem('role');
  public editableBa: User = new User();
  private subscriptions: Subscription[] = [];

  constructor(private router: Router,
              private taskService: TaskService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private userService: UserService) {
  }

  ngOnInit() {

  }

  public _openModal(template: TemplateRef<any>, user: User): void {
    this.modalRef = this.modalService.show(template);
    this.editableBa.username = localStorage.getItem('user');
    this.editableBa.email = localStorage.getItem('mail');
    this.loadTasks();
  }

  setTask(task: Task) {
    this.taskService.currentTask = task;
    this.router.navigate(['task']);
    this._closeModal();
  }


  public _updateUser(): void {
    this.loadingService.show();
    this.editableBa.id = localStorage.getItem("id");
    this.subscriptions.push(this.userService.updateUser(this.editableBa).subscribe((data:User) => {
      localStorage.removeItem('mail');
      if(data.email!==null) {
        localStorage.removeItem('mail');
        localStorage.setItem('mail',data.email);
      }
      this._closeModal();
      this.refreshBa();
      this.loadingService.hide();
    }));
  }

  loadTasks() {
    this.taskService.getTaskByAssignee(this.editableBa.username).subscribe(data => {
      this.task = data as Task[];
    })
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  private refreshBa(): void {
    this.editableBa = new User();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
