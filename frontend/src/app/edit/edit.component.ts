import {Component, OnInit, Input, TemplateRef} from '@angular/core';
import {Task} from '../model/task';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {User} from "../model/user";
import {TaskService} from "../service/task/task.service";
import {UserService} from "../service/user/user.service";
import {TaskComponent} from "../task/task.component";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  users: User[];
  public modalRef: BsModalRef;
  public editableBa: Task = new Task();
  taskFromTable = this.taskService.currentTask;
  private subscriptions: Subscription[] = [];

  constructor(private task: TaskComponent,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private taskService: TaskService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.loadUsers();
  }

  public _openModal(template: TemplateRef<any>, task: Task): void {
    this.modalRef = this.modalService.show(template);
  }

  public updateTask(): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.updateTask(this.taskFromTable).subscribe(() => {
      this._closeModal();
      this.refreshBa();
      this.loadingService.hide();
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

  loadUsers(): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.getUsers().subscribe(data => {
      this.users = data as User[];
      this.loadingService.hide();
    }));
  }
}
