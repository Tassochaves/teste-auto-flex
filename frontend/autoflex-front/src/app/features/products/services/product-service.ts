import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private readonly apiUrl = 'http://localhost:8080/api/v1/products';
  private readonly _httpClient = inject(HttpClient);

  findAll(): Observable<Product[]>{
    return this._httpClient.get<Product[]>(this.apiUrl);
  }

  save(product: Partial<Product>): Observable<Product> {
    return this._httpClient.post<Product>(this.apiUrl, product);
  }

  delete(id: number): Observable<void> {
    return this._httpClient.delete<void>(`${this.apiUrl}/${id}`);
  }
}