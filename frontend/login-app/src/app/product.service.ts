import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseURL:string ="http://localhost:9191/product"
  constructor(public httpClient:HttpClient) { }

  storeProduct(product:any):Observable<string> {
    return this.httpClient.post(`${this.baseURL}/store`,product,{responseType:"text"})
  }

  viewAllProducts():Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseURL}/find`)
  }
}
