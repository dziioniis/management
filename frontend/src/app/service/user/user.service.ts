import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
 saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
 }
   getUsers(): Observable<User[]> {
   return this.http.get<User[]>('http://localhost:8080/api/user');
  }
}
