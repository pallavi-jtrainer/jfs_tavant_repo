import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ViewpostsComponent } from '../components/posts/viewposts/viewposts.component';
import { AddpostComponent } from '../components/posts/addpost/addpost.component';
import { DetailsComponent } from '../components/posts/details/details.component';
import { LoginComponent } from '../components/users/login/login.component';

const routes: Routes = [
  {path: 'posts/list/:id', component: ViewpostsComponent},
  {path: 'posts/create/:id', component: AddpostComponent},
  {path: 'posts/:id/:user', component: DetailsComponent},
  {path: 'posts/title/:title/:user', component: DetailsComponent},
  {path: 'login', component: LoginComponent},
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
