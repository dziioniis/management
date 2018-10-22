import { Component, OnInit,TemplateRef } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Task} from "../model/task";
import {TaskService} from "../service/task/task.service";

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
 public editMode = false;
       public modalRef: BsModalRef;
public editableBa: Task = new Task();
private subscriptions: Subscription[] = [];
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private taskService:TaskService) { }

  ngOnInit() {
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
  public _addTask(): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.saveTask(this.editableBa).subscribe(() => {
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



}
