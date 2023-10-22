import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthServiceService} from '../../auth-service.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
formGroup: FormGroup;
  constructor(private authService:AuthServiceService,
              private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
    this.initForm();
    if(this.authService.isLoggedIn()){
      this.router.navigate(["dashboard"]);
    }
  }
  initForm(){
    this.formGroup = new FormGroup( {
        email: new FormControl('',[Validators.required]),
        password: new FormControl('', [Validators.required])
    }
    );
  }
  loginProcess(){
    if(this.formGroup.valid){
      this.authService.login(this.formGroup.value).subscribe(result =>{
        console.log("Response success ", result);
        this.authService.setToken(result.jwt);
        this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>  <b>Success</b>', '', {
          disableTimeOut: false,
          enableHtml: true,
          closeButton: true,
          toastClass: "alert alert-success alert-with-icon",
        });
        this.router.navigate(['dashboard']);
      }, error => {
        this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Error <b>Bad Credentials</b>', '', {
          disableTimeOut: false,
          enableHtml: true,
          closeButton: true,
          toastClass: "alert alert-danger alert-with-icon",
        });
        console.log("Error", error);
      })
    }
  }

}
