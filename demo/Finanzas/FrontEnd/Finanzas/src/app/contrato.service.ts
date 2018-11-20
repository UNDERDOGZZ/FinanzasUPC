import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContratoService {
  private baseUrl = "http://localhost:8080/contratos";

  constructor(private http:HttpClient) { }

  getContrato(id:number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createContrato(usuario: Object)
  {
    return this.http.post(`${this.baseUrl}`, usuario);
  }

  deleteContrato(id: number): Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType:
      'text'});
  }

  getContratos():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  getContratosByEmpresa(empresa:string):Observable<any>{
    return this.http.get(`${this.baseUrl}/search/${empresa}`);
  }

}