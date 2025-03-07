import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ViewpostsComponent } from '../components/posts/viewposts/viewposts.component';
import { AddpostComponent } from '../components/posts/addpost/addpost.component';

const routes: Routes = [
  {path: 'posts/list', component: ViewpostsComponent},
  {path: 'posts/create', component: AddpostComponent},
  {path: '', redirectTo: 'posts/list', pathMatch: 'full'}
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
