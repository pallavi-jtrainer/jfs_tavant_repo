import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = [];

  constructor() {
    this.products = [
      { id: 1, productName: 'Memory Card', price: 1300 },
      { id: 2, productName: 'Bluetooth Mouse', price: 1200 },
      { id: 3, productName: 'Power bank', price: 2300 },
      { id: 4, productName: 'Headphones', price: 1000 },
      { id: 5, productName: 'Laptop', price: 15000 }
    ]
  }

  getAllProducts(): Observable<Product[]> {
    return of(this.products);
  }

  getProductById(id: number): Observable<Product>{
    var product = this.products.find(p => p.id == id);
    if(product)
      return of(product);
    else
      throw new Error("product with id " + id + " not found");
  }
}
