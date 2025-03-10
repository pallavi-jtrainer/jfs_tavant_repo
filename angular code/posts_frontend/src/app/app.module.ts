import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AddpostComponent } from './components/posts/addpost/addpost.component';
import { ViewpostsComponent } from './components/posts/viewposts/viewposts.component';
import { HttpClientModule } from '@angular/common/http';
import { PostsService } from './services/postsservice.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { LoginComponent } from './components/users/login/login.component';
import { RegisterComponent } from './components/users/register/register.component';
import { ProfileComponent } from './components/users/profile/profile.component';
import { DetailsComponent } from './components/posts/details/details.component';
import { UsersService } from './services/users.service';
import { MatchPasswordDirective } from './directives/match-password.directive';

@NgModule({
  declarations: [
    AppComponent,
    AddpostComponent,
    ViewpostsComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    DetailsComponent,
    MatchPasswordDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [PostsService, UsersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
