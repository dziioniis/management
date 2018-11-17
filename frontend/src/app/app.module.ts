
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { FormsModule }   from '@angular/forms';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import { NewUserComponent } from './new-user/new-user.component';
import { NewProjectComponent } from './new-project/new-project.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { TableComponent } from './table/table.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { TimeComponent } from './time/time.component';
import {TimePickerModule} from 'timepicker';
import { CollapseBasicComponent } from './collapse-basic/collapse-basic.component';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { ProgressbarModule } from 'ngx-bootstrap';
import { ProgressComponent } from './progress/progress.component';
import { TaskComponent } from './task/task.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { PaginationModule } from 'ngx-bootstrap';
import { UsersComponent } from './users/users.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { EditComponent } from './edit/edit.component';
import { UploadComponent } from './upload/upload.component';
import {FileUploadModule} from 'ng2-file-upload';
import { TopLabelComponent } from './top-label/top-label.component';


const routes: Routes = [
{ path: '', pathMatch: 'full', redirectTo: 'login'},
  { path: 'table', component: TableComponent},
  { path: 'login', component: LoginComponent},
  { path: 'task', component: TaskComponent}
];

@NgModule({
  declarations: [
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
  ],
  imports: [
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
  providers: [TableComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
