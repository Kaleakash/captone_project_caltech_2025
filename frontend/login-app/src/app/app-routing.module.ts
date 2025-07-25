import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { AdminProductOperationComponent } from './admin-product-operation/admin-product-operation.component';
import { CustomerProductOperationComponent } from './customer-product-operation/customer-product-operation.component';

// http://localhost:4200

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"signUp",component:SignupComponent},
  {path:"changePassword",component:ChangePasswordComponent},
  {path:"admin-home",component:AdminDashboardComponent,children:[
    {path:"product-details",component:AdminProductOperationComponent}
  ]},
  {path:"customer-home",component:CustomerDashboardComponent,children:[
    {path:"product-details",component:CustomerProductOperationComponent}
  ]},
  {path:"login",redirectTo:"",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
