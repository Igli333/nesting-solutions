import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dorm-structure',
  templateUrl: './dorm-structure.component.html',
  styleUrls: ['./dorm-structure.component.scss']
})
export class DormStructureComponent implements OnInit {

  floorNumber: number;
  freeRooms: number;
  takenRooms: number;
  totalRooms: number;
  constructor() { }

  ngOnInit(): void {
  }
  methodToTest(any){
    this.floorNumber = any;
    if(any>0 && any<3) {
      this.freeRooms = 14;
      this.takenRooms = 36;
      this.totalRooms = 50;
    } else if (any > 3 && any < 7){
      this.freeRooms = 5;
      this.takenRooms = 55;
      this.totalRooms = 60;
    } else {
      this.freeRooms = 2;
      this.takenRooms = 68;
      this.totalRooms = 70;
    }
    alert("Kati "+this.floorNumber+"/ Total Dhoma "+this.totalRooms+" / Të Lira "+this.freeRooms+" / Të Zëna "+this.takenRooms);
  }
  methodHover(any){
    this.floorNumber = any;
    if(any>0 && any<3) {
      this.freeRooms = 14;
      this.takenRooms = 36;
      this.totalRooms = 50;
    } else if (any > 3 && any < 7){
      this.freeRooms = 5;
      this.takenRooms = 55;
      this.totalRooms = 60;
    } else {
      this.freeRooms = 2;
      this.takenRooms = 68;
      this.totalRooms = 70;
    }
  }

}
