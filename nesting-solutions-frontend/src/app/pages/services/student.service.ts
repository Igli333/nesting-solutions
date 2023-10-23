import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import * as myGlobals from "../../../global";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getAllStudents() {
    // const url = myGlobals.host + "api/students/all";
    const url = "http://localhost:8080/api/students/all";
    const token = localStorage.getItem("token");
    const headers = new HttpHeaders({
      Authorization: "Bearer "+token,
    });
    console.log("Headeri qe dergoj ", headers);
    return this.http.get(url,{headers});
  }
}
