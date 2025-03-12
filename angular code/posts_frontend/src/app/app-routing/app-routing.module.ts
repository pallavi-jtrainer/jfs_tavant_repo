import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ViewpostsComponent } from '../components/posts/viewposts/viewposts.component';
import { AddpostComponent } from '../components/posts/addpost/addpost.component';
import { DetailsComponent } from '../components/posts/details/details.component';
import { LoginComponent } from '../components/users/login/login.component';
import { RegisterComponent } from '../components/users/register/register.component';
import { ProfileComponent } from '../components/users/profile/profile.component';
import { ViewusersComponent } from '../components/users/viewusers/viewusers.component';

const routes: Routes = [
  {path: 'posts/list/:id', component: ViewpostsComponent},
  {path: 'posts/create/:id', component: AddpostComponent},
  {path: 'posts/:id/:user', component: DetailsComponent},
  {path: 'posts/title/:title/:user', component: DetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'user/:id', component: ProfileComponent},
  {path: 'users', component: ViewusersComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
