import { Employee } from './employee.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class EmployeeService {

  formData: Employee;
  readonly rootURL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:one-line
  postEmployee(formData: Employee){
    console.log(formData.empcode);
    return this.http.post(this.rootURL + '/employee', formData);
  }

}
