export interface Product{
    id: String,
    name :String
    price :number
    promotion : Boolean
}

export interface PageProduct{
    content : Product[];
    size : number;
    page : number;
    totalPages : number;

}