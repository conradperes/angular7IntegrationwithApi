import { Employee } from './../../shared/employee.model';
import { EmployeeService } from './../../shared/employee.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private service: EmployeeService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    // tslint:disable-next-line:curly
    if (form != null)
      form.resetForm();
    this.service.formData = {
      employeeID: null,
      fullName: '',
      position: '',
      empcode: '',
      mobile: ''
    };
  }

  onSubmit(form: NgForm) {
    this.insertRecord(form);
    this.print(form);
  }

  private print(form: NgForm) {
    console.log(form);
  }

  insertRecord(form: NgForm) {
    // tslint:disable-next-line:one-line
    this.service.postEmployee(form.value).subscribe(res => {
      this.toastr.success('Insert Sucessfully', 'EMP. Register');
      this.resetForm(form);
    });
  }
}
