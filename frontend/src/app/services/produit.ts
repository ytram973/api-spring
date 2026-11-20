import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Training {
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
}

@Injectable({ providedIn: 'root' })
export class ProduitService {
  private http = inject(HttpClient);
  private apiUrl = '/api/trainings';

  getAll(): Observable<Training[]> {
    return this.http.get<Training[]>(this.apiUrl);
  }

  create(training: Omit<Training, 'id'>): Observable<Training> {
    return this.http.post<Training>(this.apiUrl, training);
  }
}