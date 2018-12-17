import {Component} from '@angular/core';
@Component({
selector: 'app-employee',
templateUrl: `employee.html`,
styleUrls: ['employee.css'],
})
export class EmployeeComponent {
FirstName: String = 'Uday';
LastName: String = 'Koleti';
Gender: String = 'Male';
Age: Number = 23;
}
