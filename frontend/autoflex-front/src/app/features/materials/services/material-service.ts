import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Material } from '../models/material.model';

@Injectable({
  providedIn: 'root',
})
export class MaterialService {
  private readonly apiUrl = 'http://localhost:8080/api/v1/materials';
  private readonly _httpClient = inject(HttpClient);

  findAll(): Observable<Material[]> {
    return this._httpClient.get<Material[]>(this.apiUrl);
  }
}
