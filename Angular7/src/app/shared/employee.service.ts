import { Employee } from './employee.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class EmployeeService {

  formData: Employee;
  list: Employee[];
  readonly rootURL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:one-line
  postEmployee(formData: Employee){
    console.log(formData.empcode);
    return this.http.post(this.rootURL + '/employee', formData);
  }

    // tslint:disable-next-line:one-line
    putEmployee(formData: Employee){
      console.log(formData.empcode);
      return this.http.put(this.rootURL + '/employee', formData);
    }
    // tslint:disable-next-line:one-line
    deleteEmployee(id: number){
      return this.http.delete(this.rootURL + '/employee/' + id);

    }

  // tslint:disable-next-line:one-line
  refreshList(){
   this.http.get(this.rootURL + '/employee')
   .toPromise().then(res => this.list = res as Employee[]);
  }

}
