import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Tarefa } from './tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private url: string;

  constructor(private http: HttpClient) { 
    this.url = 'http://localhost:8080'
  }

  public findAll(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(this.url);
  }


}
