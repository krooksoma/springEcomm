export class Product {
    //public <name>:Data Type - when prefixed it is a parameter property
    constructor(
        public sku:string, 
        public name:string,
        public description:string,
        public unitPrice:number,
        public imageUrl:string,
        public active:boolean,
        public unitsInStock:number, 
        public dateCreated: Date, 
        public lastUpdated: Date
    ){

    }
}
