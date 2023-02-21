import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

// Services can be injected into other classes/components/ "root" can be injected globally
@Injectable({
  providedIn: 'root'
})

export class ProductService {
  // Url for SB Api
  private baseUrl = 'http://localhost:8080/api/products';

  // injects httpClient
  constructor(private httpClient: HttpClient){}
  
  getProductList(): Observable<Product[]>{
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      // maps the json data and returns an array
      map(response => response._embedded.products)
    );
  }
}

// Unwraps JSON from Spring Data Rest _embedded entry.
interface GetResponse{
  _embedded:{
    products: Product[];
  }
}
