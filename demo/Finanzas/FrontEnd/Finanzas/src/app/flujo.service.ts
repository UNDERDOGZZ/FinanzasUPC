import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlujoService {

  private baseUrl = "http://localhost:8080/flujos";

  constructor(private http:HttpClient) { }

  saveFlujo(contrato: Object){
    return this.http.get(`${this.baseUrl}/saveFlujo`, contrato);
  }

  createUsuario(usuario: Object)
  {
    return this.http.post(`${this.baseUrl}`, usuario);
  }

  getByContrato(id: number):Observable<any>
  {
    return this.http.get(`${this.baseUrl}/contrato/${id}`);
  }
}