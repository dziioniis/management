import {Component, OnInit, TemplateRef} from '@angular/core';
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Router} from "@angular/router";
import {ProjectService} from "../service/project/project.service";
import {el} from "@angular/platform-browser/testing/src/browser_util";


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  ticketCode: string;
  private page: number = 0;
  private pages: Array<number>;
  private task: Task;
  public editMode = false;


  setTask(methodTask: Task): void {
    this.taskService.currentTask = methodTask;
    this.task = methodTask;
    localStorage.setItem("task", methodTask.id);
  }

  public tasks: Task[];

  public editableBa: Task = new Task();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(
    private projectServic:ProjectService,
    private router:Router,
    private taskService: TaskService,
    private loadingService: Ng4LoadingSpinnerService,
    private modalService: BsModalService) {
  }

  setPage(i, event: any) {
    event.preventDefault();
    this.page = i;
    this.loadTasks();
  }

  ngOnInit(): void {
    this.loadTasks()
  }

  public _closeModal(): void {
    this._updateTask();
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, task: Task): void {

    if (task) {
      this.editMode = true;
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  public _updateTask(): void {
    this.loadTasks();
  }

  private refreshBa(): void {
    this.editableBa = new Task();
  }

  private loadTasks(): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.getTasks(this.page).subscribe(data => {
      this.tasks = data['content'];
      this.pages = new Array(data['totalPages']);
      this.loadingService.hide();
    }));
  }

  private searchTask() {
    if(this.ticketCode!=null) {
      this.taskService.getTaskByTicketCode(this.ticketCode)
        .subscribe(tasks => {
          if (tasks != "") {
            this.tasks = tasks
          } else {
            this.loadTasks();
          }
        });
      this.ticketCode=null;
    }else{
      this.loadTasks()
    }
  }
}
