import { Component, OnInit, Input} from '@angular/core';
import{Attachement} from '../model/attachement';
import {  FileUploader } from 'ng2-file-upload/ng2-file-upload';
import {UploadService } from '../service/upload/upload.service';
import {TaskService} from "../service/task/task.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {TaskComponent} from '../task/task.component';


@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
taskId:number;
attachements:Attachement[];
private subscriptions: Subscription[] = [];

   constructor( private uploadService: UploadService ,
                private loadingService: Ng4LoadingSpinnerService,
                private taskComponent:TaskComponent
              )  { }


  ngOnInit() {
     alert(this.taskId);
    this.loadAtt();
    this.uploader.onAfterAddingFile = (file) => {
      file.withCredentials = false;
    };
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
      console.log('ImageUpload:uploaded:', item, status, response);
      alert('File uploaded successfully');
      this.upDateAtt();
    };
  }
  public upDateAtt(){
     this.loadAtt();
  }
  public uploader:FileUploader = new FileUploader({url: 'http://localhost:8080/api/upload/'+localStorage.getItem('task')});
  private loadAtt():void{
      this.subscriptions.push(this.uploadService.getFiles(localStorage.getItem("task")).subscribe(data => {
      this.attachements = data as Attachement[];
      this.loadingService.hide();
    }))
  }
}
