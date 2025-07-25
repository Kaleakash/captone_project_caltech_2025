export class Orders {   // map to entity class orders 
    constructor(
        public oid:number,
        public pid:number,
        public odateandtime:string,
        public qty:number,
        public totalprice:number
    ){}
}
