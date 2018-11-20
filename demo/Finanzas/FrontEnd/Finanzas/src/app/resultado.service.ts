import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultadoService {

  private baseUrl = "http://localhost:8080/resultados";

  constructor(private http:HttpClient) { }

  getAllResultadoByContratoId(id: number):Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/contrato/todos/${id}`);
  }
}