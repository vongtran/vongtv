import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { Person } from './person';

@Injectable()
export class PersonService {
  private baseUrl: string = 'http://localhost:4200/api';
  constructor(private http : Http){
  }

  getAll(): Observable<Person[]>{
    let people$ = this.http
      .get(`${this.baseUrl}/personalDatas`, { headers: this.getHeaders()})
      .map(mapPersons)
      .catch(handleError);
      return people$;
  }

  private getHeaders(){
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    return headers;
  }
  get(id: number): Observable<Person> {
    let person$ = this.http
      .get(`${this.baseUrl}/personDatas/${id}`, {headers: this.getHeaders()})
      .map(mapPerson)
      .catch(handleError);
      return person$;
  }

}
      
function mapPersons(response:Response): Person[]{
  return response.json()._embedded.personalDatas.map(toPerson)
}

function toPerson(r:any): Person{
  let person = <Person>({
    id: extractId(r),
    firstName: r.firstName,
    lastName: r.lastName,
    description: r.description,
    values: r.values,
    sumValues() : number {
        let total = 0;
        for (var i = 0; i < this.values.length; i++) {
          total += this.values[i];
        }    
        return total;    
    }
  });
  console.log('Parsed person:', person);
  return person;
}

function extractId(personData:any){
  let extractedId = personData._links.self.href.replace('http://localhost:4200/api/personalDatas/','');
  return parseInt(extractedId);
}

function mapPerson(response:Response): Person{
  return toPerson(response.json());
}

function handleError (error: any) {
  let errorMsg = error.message || `Couldn't retrieve data!`
  console.error(errorMsg);

  return Observable.throw(errorMsg);
}
