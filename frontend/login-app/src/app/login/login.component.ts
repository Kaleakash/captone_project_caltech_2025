import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Login } from '../login';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

loginRef = new FormGroup({
emailid:new FormControl(''),
password:new FormControl(''),
typeofuser:new FormControl('')
});
msg:string=""
  constructor(private ls:LoginService,private router:Router){         // DI for LoginService class 

  }
  signIn():void{
    let login:any = this.loginRef.value;
    //console.log(login);
    this.ls.signIn(login).subscribe({
      next:(response:any) => {
       // console.log(response)
      if(response === "Admin login successfully"){
          this.router.navigate(['/admin-home'],{skipLocationChange:true}); // Navigate to admin dashboard
      }else if(response === "Customer login successfully"){
          sessionStorage.setItem("emailid",login.emailid); 
          this.router.navigate(['/customer-home'],{skipLocationChange:true}); // Navigate to customer dashboard
      }else {
        this.msg=response; // Store the response message
      }
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
