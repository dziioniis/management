import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../../model/project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  currentProject:Project;

  constructor(private http: HttpClient) {}
  saveProject(project:Project):Observable<Project>{
    return this.http.post<Project>('/api/project',project);
}
  getProjects(page:number): Observable<Project[]> {
    return this.http.get<Project[]>('/api/project/page?page='+page);
  }
  getProjectsAll  (): Observable<Project[]> {
    return this.http.get<Project[]>('http://localhost:8080/api/project/all');
  }
}
