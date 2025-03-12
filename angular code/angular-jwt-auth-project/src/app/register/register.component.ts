import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: any = {
    username: null,
    password: null,
    email: null
  }

  isSuccess: boolean = false;
  isRegisterFailed: boolean = false;
  errorMessage: string = '';

  constructor(private authService: AuthService) {}

  onSubmit() {
    const {username, email, password} = this.registerForm;

    this.authService.register(username, password, email)
    .subscribe({
      next: (data) => {
        console.log(data);
        this.isSuccess = true;
        this.isRegisterFailed = false;
      },
      error: (err) => {
        this.errorMessage = err.error.message;
        this.isRegisterFailed = true;
        this.isSuccess = false;
      }
    });
  }

}
