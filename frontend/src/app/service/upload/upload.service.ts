import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {LoginService} from "../login/login.service";

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http:HttpClient,private loginService:LoginService) { }

 getFiles(task:any): Observable<any> {
    return this.http.get('http://localhost:8080/api/download/get/'+task,{headers:this.loginService.head});
  }

}
