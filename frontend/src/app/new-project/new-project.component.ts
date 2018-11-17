import { Component, OnInit,TemplateRef } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Project} from "../model/project";
import {ProjectService} from "../service/project/project.service";


@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

 public editMode = false;
       public modalRef: BsModalRef;
public editableBa: Project = new Project();
private subscriptions: Subscription[] = [];

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private projectService:ProjectService ) { }

  ngOnInit() {
  }
public _openModal(template: TemplateRef<any>, project: Project): void {

    if (project) {
      this.editMode = true;
    } else {
      this.refreshBa();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }
  public _addProject(): void {
    this.loadingService.show();
    this.subscriptions.push(this.projectService.saveProject(this.editableBa).subscribe(() => {
      this._closeModal();
      this.refreshBa();
      this.loadingService.hide();
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

}
