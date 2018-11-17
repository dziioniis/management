import { Component, OnInit,TemplateRef } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {User} from "../model/user";
import {UserService} from "../service/user/user.service";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {
       public editMode = false;
       public modalRef: BsModalRef;
public editableBa: User = new User();
private subscriptions: Subscription[] = [];

  constructor( private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private userService:UserService )  { }

  ngOnInit() {
  }
public _openModal(template: TemplateRef<any>, user: User): void {

    if (user) {
      this.editMode = true;
    } else {
      this.refreshBa();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }
  public _addUser(): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.saveUser(this.editableBa).subscribe(() => {
      this._closeModal();
      this.refreshBa();
      this.loadingService.hide();
    }));
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
