import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.scss']
})
export class ContractsComponent implements OnInit {

  contractList: any[] = [
    {id:6, name:"Contract #232", studentName:"Alger Pire", contractEndDate:"31-12-2023", roomType: "Single Room", price: 200},
    {id:7, name:"Contract #252", studentName:"Altin Gjokurti", contractEndDate:"31-05-2024", roomType: "Double Room", price: 150},
    {id:8, name:"Contract #149", studentName:"Joana Sari", contractEndDate:"28-02-2024", roomType: "Single Room", price: 240},
    {id:9, name:"Contract #167", studentName:"Merlind Gjoni", contractEndDate:"01-03-2024", roomType: "1 Bedroom", price: 180},
    {id:10, name:"Contract #123", studentName:"Uran Tangu", contractEndDate:"31-07-2024", roomType: "2 Bedroom", price: 170},
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
