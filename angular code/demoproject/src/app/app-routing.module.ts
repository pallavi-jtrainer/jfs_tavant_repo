import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { DepositComponent } from './deposit/deposit.component';
import { TodosComponent } from './todos/todos.component';
// import { CoinsComponent } from './deposit/coins/coins.component';
// import { NotesComponent } from './deposit/notes/notes.component';

const routes: Routes = [
  {path: 'withdraw', component: WithdrawComponent},
  {path: 'deposit', component: DepositComponent,
    loadChildren: () => import('./deposit/deposit.module')
      .then(m=>m.DepositModule)
  },
  {
    path: 'todos', component: TodosComponent,
    loadChildren: () => import('./todos/todos/todos.module')
      .then(m => m.TodosModule)
  }
    // children: [
    //   {path: 'coins', component: CoinsComponent},
    //   {path:'notes', component: NotesComponent}
    // ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
