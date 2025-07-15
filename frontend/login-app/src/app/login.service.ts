import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
      lOGIN_BASE_URL:string="http://localhost:9090/login";

  constructor(private httpClient:HttpClient) { }  // DI for HttpClient 

  signIn(login:Login):Observable<string>{
    return this.httpClient.post(`${this.lOGIN_BASE_URL}/signIn`, login, {responseType: 'text'});
  }

  signUp(login:Login):Observable<string>{
    return this.httpClient.post(`${this.lOGIN_BASE_URL}/signUp`, login, {responseType: 'text'});
  }
  
}
