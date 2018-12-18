import {Component, OnInit, Input} from '@angular/core';
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";
import {Comment} from "../model/comment";
import {CommentService} from "../service/comment/comment.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {TableComponent} from '../table/table.component';
import {EditComponent} from '../edit/edit.component';
import {UploadComponent} from '../upload/upload.component';
import {Project} from "../model/project";
import {ProjectService} from "../service/project/project.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  role = localStorage.getItem('role');
  resolvedCondition: boolean = true;
  public date = new Date;
  public day: number = this.date.getDate();
  public monthIndex: number = this.date.getMonth();
  public year: number = this.date.getFullYear();
  taskFromTable = this.taskService.currentTask;
  projectFromTable = this.projectService.currentProject;
  name = localStorage.getItem('user');

  public comments: Comment[];
  public editableBa: Comment = new Comment();
  private subscriptions: Subscription[] = [];
  public status: string;

  constructor(private router: Router,
              private projectService: ProjectService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private commentService: CommentService,
              private taskService: TaskService) {
  }

  public startStatus(): void {
    this.loadingService.show();
    this.taskFromTable.status = "start";
    this.subscriptions.push(this.taskService.changeTask(this.taskFromTable).subscribe(() => {
      this.loadingService.hide();
    }));
  }

  public reStatus(): void {
    this.loadingService.show();
    this.taskFromTable.status = "open";
    this.taskFromTable.resolved = null;
    this.taskFromTable.closed = null;
    this.subscriptions.push(this.taskService.changeTask(this.taskFromTable).subscribe(() => {
      this.loadingService.hide();
    }));
  }

  refreshTask(): void {
    this.taskFromTable = this.taskService.currentTask
  }

  public preclosedStatus(): void {
    this.closedStatus();
    this.taskService.getTaskByProjectCode(this.taskFromTable.projectCode);

  }

  public closedStatus(): void {
    this.taskFromTable.closed = this.year + "/" + this.monthIndex + "/" + this.day;
    this.loadingService.show();
    this.taskFromTable.status = "closed";
    this.subscriptions.push(this.taskService.changeTask(this.taskFromTable).subscribe(() => {
      this.loadingService.hide();
    }));

  }

  public resolvedStatus(): void {
    this.resolvedCondition = false;
    this.taskFromTable.resolved = this.year + "/" + this.monthIndex + "/" + this.day;
    this.loadingService.show();
    this.taskFromTable.status = "resolved";
    this.subscriptions.push(this.taskService.changeTask(this.taskFromTable).subscribe(() => {
      this.loadingService.hide();
    }));
  }

  public readyStatus(): void {
    this.loadingService.show();
    this.taskFromTable.status = "readyForTest";
    this.subscriptions.push(this.taskService.changeTask(this.taskFromTable).subscribe(() => {
      this.loadingService.hide();
    }));
  }

  private refreshBa(): void {
    this.editableBa = new Comment();
  }


  ngOnInit() {
    if ((localStorage.getItem('user') == null) || (this.taskFromTable == null)) {
      this.router.navigate( ['home']);
    }
    this.loadComments()

  }

  public _saveComment(): void {
    this.loadingService.show();
    this.editableBa.taskId = localStorage.getItem("task");
    this.editableBa.author = localStorage.getItem('user');
    this.subscriptions.push(this.commentService.saveComment(this.editableBa).subscribe(() => {
      this.refreshBa();
      this._updateComment();
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public _updateComment(): void {
    this.loadComments();
  }

  private loadComments(): void {
    this.loadingService.show();
    this.subscriptions.push(this.commentService.getComments(this.taskFromTable.id).subscribe(cmnts => {
      this.comments = cmnts as Comment[];
      this.loadingService.hide();
    }));

  }
}

