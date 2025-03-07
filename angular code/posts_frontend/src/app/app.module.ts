import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AddpostComponent } from './components/posts/addpost/addpost.component';
import { ViewpostsComponent } from './components/posts/viewposts/viewposts.component';
import { HttpClientModule } from '@angular/common/http';
import { PostsService } from './services/postsservice.service';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    AddpostComponent,
    ViewpostsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
