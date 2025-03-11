import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Users } from 'src/app/models/users';
import { UsersService } from 'src/app/services/users.service';
import PasswordValidation from 'src/app/utils/passwordvalidation';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: FormGroup = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl('')
  });

  submitted = false;

  user: Users = {
    userId: 0,
    firstName: '',
    lastName: '',
    email: '',
    username: '',
    password: ''
  }

  constructor(private formBuilder: FormBuilder,
    private userService: UsersService,
    private router: Router
  ) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName:['', [Validators.required,
        Validators.minLength(3), Validators.maxLength(25)]],
      lastName:['', [Validators.required,
        Validators.minLength(3), Validators.maxLength(25)]],
      email: ['', [Validators.required, Validators.email]],
      username: ['', [Validators.required, Validators.minLength(6)]],
      password:['',
        [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', [Validators.required,
        Validators.minLength(8)]]
    },
    {
      validator: PasswordValidation.match('password', 'confirmPassword')
    }
  );
  }

  get f(): { [key:string]: AbstractControl}{
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }

  // if(this.registerForm.value.password === this.registerForm.value.confirmPassword) {
      this.user.firstName = this.registerForm.value.firstName;
      this.user.lastName = this.registerForm.value.lastName;
      this.user.email = this.registerForm.value.email;
      this.user.username = this.registerForm.value.username;
      this.user.password = this.registerForm.value.password;
  //  }

    this.userService.createUser(this.user)
    .subscribe({
      next: (data) => {
        console.log(data);
        this.router.navigate(['/login']);
      }, error: (e) => console.log(e)
    })
    // console.log(this.registerForm.value);
  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }
}
