import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import {HttpClientModule} from '@angular/common/http'; // Import HttpClientModule for HTTP requests
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminProductOperationComponent } from './admin-product-operation/admin-product-operation.component';
import { CustomerProductOperationComponent } from './customer-product-operation/customer-product-operation.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ChangePasswordComponent,
    AdminDashboardComponent,
    CustomerDashboardComponent,
    AdminProductOperationComponent,
    CustomerProductOperationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule ,// Import HttpClientModule for HTTP requests
    ReactiveFormsModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
