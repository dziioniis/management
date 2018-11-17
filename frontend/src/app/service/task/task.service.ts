import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";
import {Task} from "../../model/task";
import {LoginService} from "../login/login.service";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  setTask:Task;
  constructor(private http: HttpClient,private loginService:LoginService) { }
  changeTask(task:Task):Observable<Task>{
  return this.http.post<Task>('http://localhost:8080/api/task/change',task,{headers:this.loginService.head});
 }
  saveTask(task:Task):Observable<Task>{
  return this.http.post<Task>('/api/task',task,{headers:this.loginService.head});
 }
   updateTask(task:Task):Observable<Task>{
  return this.http.post<Task>('/api/task/update',task,{headers:this.loginService.head});
 }
  getTasks(page:number): Observable<Task[]> {
    return this.http.get<Task[]>('http://localhost:8080/api/task?page='+page,{headers:this.loginService.head});
  }
  getTaskByTicketCode(ticketCode:string): Observable<any> {
    return this.http.get(`http://localhost:8080/api/task/${ticketCode}`,{headers:this.loginService.head});
  }

}



