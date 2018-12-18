import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {TooltipModule} from 'ngx-bootstrap/tooltip';
import {ModalModule} from 'ngx-bootstrap/modal';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {NewUserComponent} from './new-user/new-user.component';
import {NewProjectComponent} from './new-project/new-project.component';
import {NewTaskComponent} from './new-task/new-task.component';
import {TableComponent} from './table/table.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {TimeComponent} from './time/time.component';
import {TimePickerModule} from 'timepicker';
import {CollapseBasicComponent} from './collapse-basic/collapse-basic.component';
import {CollapseModule} from 'ngx-bootstrap/collapse';
import {ProgressbarModule} from 'ngx-bootstrap';
import {ProgressComponent} from './progress/progress.component';
import {TaskComponent} from './task/task.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {PaginationModule} from 'ngx-bootstrap';
import {UsersComponent} from './users/users.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {EditComponent} from './edit/edit.component';
import {UploadComponent} from './upload/upload.component';
import {FileUploadModule} from 'ng2-file-upload';
import {TopLabelComponent} from './top-label/top-label.component';
import {JwtInteceptorService} from "./service/inteceptor/jwtInterceptor.service";
import {HomeComponent} from "./home/home.component";
import {TabsModule} from 'ngx-bootstrap';
import {EditUserComponent} from "./edit-user/edit-user.component";
import {ProjectsComponent} from './projects/projects.component';
import {CarouselModule} from 'ngx-bootstrap'
import {AuthGuardService} from "./service/guard/auth-guard.service";
import { ProjectComponent } from './project/project.component';
import { AccordionModule } from 'ngx-bootstrap';
import { AlertModule } from 'ngx-bootstrap';
import { BsDatepickerModule } from 'ngx-bootstrap';


const routes: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'projects', component: ProjectsComponent},
  {path: 'tasks', component: HomeComponent},
  {path: 'main', component: HomeComponent},
  {path: 'task', component: TaskComponent},
  {path: '**', redirectTo: 'home',pathMatch:'full'}
];

@NgModule({
  declarations: [
    EditUserComponent,
    AppComponent,
    NewUserComponent,
    NewProjectComponent,
    NewTaskComponent,
    TableComponent,
    TimeComponent,
    CollapseBasicComponent,
    ProgressComponent,
    TaskComponent,
    UsersComponent,
    LoginComponent,
    EditComponent,
    UploadComponent,
    TopLabelComponent,
    HomeComponent,
    ProjectsComponent,
    ProjectComponent
  ],
  imports: [
    BsDatepickerModule.forRoot(),
    AlertModule.forRoot(),
    AccordionModule.forRoot(),
    CarouselModule.forRoot(),
    TabsModule.forRoot(),
    FileUploadModule,
    RouterModule.forRoot(routes),
    PaginationModule.forRoot(),
    Ng2SearchPipeModule,
    ProgressbarModule.forRoot(),
    CollapseModule.forRoot(),
    AngularFontAwesomeModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
  ],
  providers: [

    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInteceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
