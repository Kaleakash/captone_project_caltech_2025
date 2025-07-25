import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-customer-product-operation',
  templateUrl: './customer-product-operation.component.html',
  styleUrls: ['./customer-product-operation.component.css']
})
export class CustomerProductOperationComponent implements OnInit{
  qty:any=0;
  msg:string =""
  products:Product[]=[];
  constructor(public productService:ProductService,public orderService:OrdersService) {

  }
  setQty(qty:any){
    this.qty=qty;
  }
  ngOnInit(): void {
      this.productService.viewAllProducts().subscribe({
        next:(result:any)=> {
        this.products=result
        },
        error:(error:any)=> {
          console.log(error)
        },
        complete:()=> {
          console.log("product loaded successfully")
        }

      })
  }
  placeOrder(pid:any){
    let order={pid:pid,qty:this.qty}
    this.orderService.placeOrder(order).subscribe({
      next:(result:any)=> {
          this.msg=result;
      },
      error:(error:any)=> {
          this.msg=error.message
      },
      complete:()=> {
          console.log("done")
      }
    })
  }
}
