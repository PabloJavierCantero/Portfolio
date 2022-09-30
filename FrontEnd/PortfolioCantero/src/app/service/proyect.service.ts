import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyect } from '../model/proyect';

@Injectable({
  providedIn: 'root'
})
export class ProyectService {

  URL = 'http://localhost:8080/proyect/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Proyect[]>{
    return this.httpClient.get<Proyect[]>(this.URL+'list');
  }

  public detail(id: number): Observable<Proyect>{
    return this.httpClient.get<Proyect>(this.URL+`detail/${id}`);
  }

  public save(proyect: Proyect): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', proyect);
  }

  public update(id: number, proyect: Proyect): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, proyect);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
