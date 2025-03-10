import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from '../models/users';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseUrl = 'http://localhost:9001/api';

  constructor(private http: HttpClient) { }

  getUserById(id: number): Observable<Users> {
    return this.http.get<Users>(`${this.baseUrl}/user/${id}`);
  }

  getUserByEmail(email: string): Observable<Users> {
    return this.http.get<Users>(`${this.baseUrl}/email/${email}`);
  }

  getUsereByUsername(username: string): Observable<Users> {
    return this.http.get<Users>(`${this.baseUrl}/name/${username}`);
  }

  createUser(user: Users): Observable<Users> {
    return this.http.post<Users>(`${this.baseUrl}/user`, user);
  }
}
