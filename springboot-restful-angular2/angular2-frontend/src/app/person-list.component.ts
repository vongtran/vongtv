import { Component, OnInit } from '@angular/core';
import { Person } from './person';
import { PersonService } from "./person.service";

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html' ,
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  persons: Person[] = [];
  errorMessage: string = '';
  isLoading: boolean = true;

  constructor(private personService: PersonService) { }

  ngOnInit(){
    this.personService
      .getAll()
      .subscribe(
         /* happy path */ p => this.persons = p,
         /* error path */ e => this.errorMessage = e,
         /* onCompleted */ () => this.isLoading = false);
  }

}