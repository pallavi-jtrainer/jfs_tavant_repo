import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private AUTH_API = 'http://localhost:9001/api/auth';

  private headerOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.AUTH_API}/login`,
        { username, password }, this.headerOptions);
  }

  register(username: string, password: string, email: string): Observable<any> {
    return this.http.post<any>(`${this.AUTH_API}/register`,
        { username, password, email }, this.headerOptions);
  }

  logout(): Observable<any> {
    return this.http.post<any>(`${this.AUTH_API}/logout`, {}, this.headerOptions);
  }
}
