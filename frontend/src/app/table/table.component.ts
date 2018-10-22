import {Component, OnInit, TemplateRef} from '@angular/core';
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
 public editMode = false;

  public tasks: Task[];
  public editableBa: Task = new Task();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];

  constructor(private taskService: TaskService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { }

  ngOnInit() {
    this.loadTasks();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, task: Task): void {

    if (task) {
      this.editMode = true;
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _updateTask(): void {
    this.loadTasks();
  }

  private refreshBa(): void {
    this.editableBa = new Task();
  }

  private loadTasks(): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.getTasks().subscribe(tsks => {
      this.tasks = tsks as Task[];
      this.loadingService.hide();
    }));
}
}
