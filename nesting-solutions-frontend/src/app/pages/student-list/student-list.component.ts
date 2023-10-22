import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {

  studentsList: any[] = [
    {id:1, name:"Alger Pire", university:"UPT", contractEndDate:"31-12-2023", roomType: "Single Room"},
    {id:2, name:"Armand Gjoka", university:"UT", contractEndDate:"31-05-2024", roomType: "Double Room"},
    {id:3, name:"Elton Nore", university:"EPOKA", contractEndDate:"28-02-2024", roomType: "Single Room"},
    {id:4, name:"Altina Sesi", university:"UM", contractEndDate:"01-03-2024", roomType: "1 Bedroom"},
    {id:5, name:"Xhoana Nole", university:"UB", contractEndDate:"31-07-2024", roomType: "2 Bedroom"},
  ]

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.studentService.getAllStudents().subscribe(result => {
      console.log("Result ", result);
    }, error => {
      console.log("Error", error);
    })
  }
  test(value){
    console.log("CLient ", value);
    this.router.navigate(["/user", {data: value.id}]);
  }
}
