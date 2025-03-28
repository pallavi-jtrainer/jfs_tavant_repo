import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isLoggedIn: boolean;
  private username: string = '';

  constructor() {
    this.isLoggedIn = false;
  }

  login(username: string, password: string) {
    this.isLoggedIn = true;
    this.username = username;
    return of(this.isLoggedIn);
    // if (username === 'admin' && password === 'password') {
    //   this.isLoggedIn = true;
    //   this.username = username;
    //   return true;
    // }
    // return false;
  }
  isAdminUser() {
    if(this.username === 'admin'){
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    return this.isLoggedIn;
  }

  logout() {
    this.isLoggedIn = false;
   // this.username = '';
  }
}
