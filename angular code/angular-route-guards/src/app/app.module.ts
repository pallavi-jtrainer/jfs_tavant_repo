import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { AuthService } from './services/auth.service';
import { ProductService } from './services/product.service';
import { canActivate } from './services/auth-guard.service';
import { FormsModule } from '@angular/forms';
// import AuthGuardService from './services/auth-guard.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthService, ProductService],
  bootstrap: [AppComponent]

})
export class AppModule { }
