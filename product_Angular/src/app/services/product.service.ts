import { Injectable } from '@angular/core';
import { Observable,of, throwError } from 'rxjs';
import { PageProduct, Product } from '../model/Product';
import { UUID } from 'angular2-uuid';
import random from 'random';
import { ValidationErrors } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { KeyedWrite } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
   }

  
 public deleteProductById(id:String) : Observable<void>{
    let apiUrl = 'http://localhost:8082/product/deleteById'; 
    const params = { id: id.toString() };
    const headers = new HttpHeaders({
      'Access-Control-Allow-Origin': 'http://localhost:8082',
      'Access-Control-Max-Age': 3600,
      'Access-Control-Allow-Headers':  'Authorization',
    });
    return this.httpClient.delete<void>(apiUrl,{headers,params});
}

  public getAllProducts() : Observable<Array<Product>>{
      let apiUrl = 'http://localhost:8082/product/getAll'; 
      return this.httpClient.get<Product[]>(apiUrl, { withCredentials: true });
  }

  public searchProduct(keyword:string,page:number, size:number): Observable<PageProduct>{
    const params = { page: page.toString(), size: size.toString(), keyword: keyword.toString() };
      let apiUrl = 'http://localhost:8082/product/getAll'; 
      return this.httpClient.get<PageProduct>(apiUrl ,{ params });
  }


  public getPageProduct(page:number, size:number): Observable<PageProduct>{
    const params = { page: page.toString(), size: size.toString() };
      let apiUrl = 'http://localhost:8082/product/getAll'; 
      let response =  this.httpClient.get<PageProduct>(apiUrl ,{ params });
      console.log(response)
      return response;
  }
  public addProduct(p: Product): Observable<Product>{
    let apiUrl = 'http://localhost:8082/product/add'; 
    let response =  this.httpClient.post<Product>(apiUrl ,p);
    return response;
  }

  public getErrorMessage(field:String, error:ValidationErrors):String{
    if(error['required']){
      return field +" required";
    }
    if (error['minlength']) {
      return field+" should have at least " + error['minlength']['requiredLength']+" Characters";
    } else {
      return "";
    }
  }


}

