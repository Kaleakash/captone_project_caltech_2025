import { Orders } from "./orders";
// this class map to entity class in backend technologies 
export class Product {
    constructor(public pid:number,
        public pname:string,
        public price:number,
        public imageurl:string,
        public qty:number,
        public listoforders:Orders[]
    ){}
}
