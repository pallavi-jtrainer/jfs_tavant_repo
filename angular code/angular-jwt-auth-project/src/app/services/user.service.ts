import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private USER_API = 'http://localhost:9001/api/user';

  constructor(private http: HttpClient) { }

  getPublicInfo(): Observable<any> {
    return this.http.get<any>(`${this.USER_API}/all`, );
  }

  getUserDashBoard(): Observable<any> {
    return this.http.get<any>(`${this.USER_API}/user`);
  }

  getAdminDashBoard(): Observable<any> {
    return this.http.get<any>(`${this.USER_API}/admin`);
  }
}
