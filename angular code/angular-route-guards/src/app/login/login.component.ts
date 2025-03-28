import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidCredentials: string = '';
  username: string = '';
  password: string = '';
  currentUrl: string | null = 'home';

  constructor(private router: Router,
    private authService: AuthService,
    private route: ActivatedRoute){}

  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      this.currentUrl = params.get('currentUrl');
      if (!this.currentUrl) {
        this.currentUrl = 'home';
      }
      console.log('In LoginComponent ' + this.currentUrl);
    })
  }

  onSubmit(loginForm: any) {
    this.authService.login(loginForm.value.username, loginForm.value.password)
      .subscribe(data => {
        console.log(data);
        console.log(this.currentUrl);
        if(this.currentUrl != null) {
          this.router.navigate([this.currentUrl]);
        } else {
          this.router.navigate(['home']);
        }
      })
  }
}
