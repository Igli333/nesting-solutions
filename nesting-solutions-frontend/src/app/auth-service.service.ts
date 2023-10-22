import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http: HttpClient, private router: Router) { }
  login(data):Observable<any> {
    return this.http.post("http://localhost:8080/api/admin/authenticate", data);
  }
  setToken(token: string): void {
    localStorage.setItem('token', token);
  }
  getToken(): string | null {
    return localStorage.getItem('token');
  }
  isLoggedIn(){
    return this.getToken()!== null;
  }
  logout(){
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }
}
