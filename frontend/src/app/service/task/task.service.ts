import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";
import {Task} from "../../model/task";
import {LoginService} from "../login/login.service";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  currentTask:Task;
  constructor(private http: HttpClient,private loginService:LoginService) { }
  changeTask(task:Task):Observable<Task>{
  return this.http.post<Task>('http://localhost:8080/api/task/change',task);
 }
  saveTask(task:Task):Observable<Task>{
  return this.http.post<Task>('/api/task',task);
 }
   updateTask(task:Task):Observable<Task>{
  return this.http.post<Task>('/api/task/update',task);
 }
  getTasks(page:number): Observable<Task[]> {
    return this.http.get<Task[]>('/api/task?page='+page);
  }
  getTaskByTicketCode(ticketCode:string): Observable<any> {
    return this.http.get('/api/task/search?ticketCode='+ticketCode);
  }
  getTaskByProjectCode(projectCode:string): Observable<any> {
    return this.http.get(`/api/task/byProject?projectCode=`+projectCode);
  }
  getTaskByAssignee(assignee:string): Observable<any> {
    return this.http.get(`/api/task/byAssignee?assignee=`+assignee);
  }
}



