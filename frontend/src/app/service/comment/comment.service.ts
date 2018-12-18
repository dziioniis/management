import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../../model/comment";
import {LoginService} from "../login/login.service";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient,private loginService:LoginService) { }
   saveComment(comment:Comment):Observable<Comment>{
  return this.http.post<Comment>('/api/comment',comment);
 }
  getComments(taskId:any): Observable<Comment[]> {
    return this.http.get<Comment[]>('/api/comment/task?taskId='+taskId);
  }
}

