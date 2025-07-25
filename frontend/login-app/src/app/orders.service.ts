import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  baseURL:string ="http://localhost:9191/orders"
  constructor(public httpClient:HttpClient) { }
  placeOrder(order:any):Observable<string> {
    return this.httpClient.post(`${this.baseURL}/place`,order,{responseType:'text'})
  }
}
