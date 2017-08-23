import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { HttpModule } from '@angular/http';
import {DataTableModule} from "angular2-datatable";

import { AppComponent } from './app.component';
import { PersonService } from './person.service';
import { PersonListComponent } from './person-list.component';
import { AppRoutingModule } from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    DataTableModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
