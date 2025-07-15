import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  loginRef = new FormGroup({
  emailid:new FormControl(''),
  password:new FormControl(''),
  typeofuser:new FormControl('')
  });
  msg:string=""
    constructor(private ls:LoginService,private router:Router){         // DI for LoginService class 
  
    }
    signUp():void{
      let login:any = this.loginRef.value;
      //console.log(login);
      this.ls.signUp(login).subscribe({
        next:(response:any) => {
        this.msg=response; // Store the response message
        },
        error:(error:any) => {;
            console.log("Error occurred during login request:", error);
        },
        complete:() => {
          console.log("Login request completed");
        }
      });
  
      this.loginRef.reset(); // Reset the form after submission
    }
}
