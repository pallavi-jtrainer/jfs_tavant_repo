import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { DepositComponent } from './deposit/deposit.component';
import { DepositModule } from './deposit/deposit.module';
import { TodosComponent } from './todos/todos.component';
import { TodosModule } from './todos/todos/todos.module';
// import { DetailsComponent } from './todos/details/details.component';
// import { NotesComponent } from './deposit/notes/notes.component';
// import { CoinsComponent } from './deposit/coins/coins.component';

@NgModule({
  declarations: [
    AppComponent,
    WithdrawComponent,
    DepositComponent,
    TodosComponent
    // DetailsComponent
    // NotesComponent,
    // CoinsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DepositModule,
    TodosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
