import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUrl = "https://freetestapi.com/api/v1/todos";

  constructor(private http: HttpClient) { }

  getAllTodos(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getTodoById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getAllTodosByCompleted(completed: boolean): Observable<any>{
    return this.http.get(`${this.baseUrl}?completed=${completed}`);
  }
}
