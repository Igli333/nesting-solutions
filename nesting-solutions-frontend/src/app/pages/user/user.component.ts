import { Component, OnInit } from "@angular/core";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: "app-user",
  templateUrl: "user.component.html"
})
export class UserComponent implements OnInit {
  idParam: any;
  studentsList: any[] = [
    {id:1, name:"Alger Pire", university:"UPT", contractEndDate:"31-12-2023", roomType: "Single Room"},
    {id:2, name:"Armand Gjoka", university:"UT", contractEndDate:"31-05-2024", roomType: "Double Room"},
    {id:3, name:"Elton Nore", university:"EPOKA", contractEndDate:"28-02-2024", roomType: "Single Room"},
    {id:4, name:"Altina Sesi", university:"UM", contractEndDate:"01-03-2024", roomType: "1 Bedroom"},
    {id:5, name:"Xhoana Nole", university:"UB", contractEndDate:"31-07-2024", roomType: "2 Bedroom"},
  ]
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.idParam = params.data;
      console.log("Param ", this.idParam);
    });
  }
}
