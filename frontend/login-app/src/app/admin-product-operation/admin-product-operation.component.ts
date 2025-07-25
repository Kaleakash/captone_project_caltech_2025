import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-product-operation',
  templateUrl: './admin-product-operation.component.html',
  styleUrls: ['./admin-product-operation.component.css']
})
export class AdminProductOperationComponent implements OnInit{
  msg:string ="";
  products:Product[]=[];  
  productRef = new FormGroup({
    pid:new FormControl(),
    pname:new FormControl(),
    price:new FormControl(),
    qty:new FormControl(),
    imageurl:new FormControl(),
  })
  constructor(public productService:ProductService){}


  ngOnInit(): void {
      this.viewProduct();
  }
  viewProduct() : void {
    this.productService.viewAllProducts().subscribe({
        next:(result:any)=> {
          this.products=result
        },
        error:(error:any)=> {
          console.log(error)
        },
        complete:()=> {
          console.log("product data loaded successfully")
        }

      })
  }
  storeProduct() : void {
    let product = this.productRef.value;
    this.productService.storeProduct(product).subscribe({
      next:(result:any)=> {
          this.msg=result;
      },
      error:(error:any)=> {
          this.msg=error.message;
      },
      complete:()=> {
        console.log("data stored successfully")
        this.viewProduct();
      }
    })
  }
}
