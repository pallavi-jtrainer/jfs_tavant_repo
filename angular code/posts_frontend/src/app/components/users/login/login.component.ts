import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/models/users';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form = {
    username: '',
    password: ''
  }

  user: Users = {
    userId: 0,
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: ''
  }
  constructor(private userService: UsersService, private router: Router) {}

  onSubmit() {
    if(this.form.username === '' || this.form.password === '') {
      alert("Please enter both username and password");
      return;
    }
    if(this.form.username === 'admin' || this.form.username === 'admin@admin.com'
      && this.form.password === 'admin123') {
      console.log("Login Successful");
      this.router.navigate(['/posts/list/0']);
    } else {
      if(this.form.username.includes("@") && this.form.username.includes(".")) {
        console.log("Valid email address");
        this.userService.getUserByEmail(this.form.username)
        .subscribe({
          next: data => {
            console.log(data);
            this.user = data;
            if(this.user.password === this.form.password) {
              console.log("Login Successful");
              //navigate to the posts page for this user
              this.router.navigate(['/posts/list/' + this.user.userId]);
            }
          },
          error: e => console.log(e)
        })
      } else {
        this.userService.getUsereByUsername(this.form.username)
        .subscribe({
          next: data => {
            console.log(data);
            this.user = data;
            if(this.user.password === this.form.password) {
              console.log("Login Successful");
                //navigate to the posts page for this user
                this.router.navigate(['/posts/list/' + this.user.userId]);
            }
          },
          error: e => console.log(e)
        })
      }


    }

    //console.log(`Username: ${this.username}, Password: ${this.password}`);
  }

  onReset() {
    this.form.username = '';
    this.form.password = '';
  }
}
