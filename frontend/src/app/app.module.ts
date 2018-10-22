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



@NgModule({
  declarations: [
    AppComponent,
    NewUserComponent,
    NewProjectComponent,
    NewTaskComponent,
    TableComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
