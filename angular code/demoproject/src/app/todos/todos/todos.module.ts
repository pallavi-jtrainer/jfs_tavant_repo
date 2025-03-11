import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from '../details/details.component';
import { RouterModule } from '@angular/router';
import { TodosRoutingModule } from '../todos-routing/todos-routing.module';



@NgModule({
  declarations: [DetailsComponent],
  imports: [
    CommonModule,
    RouterModule,
    TodosRoutingModule
  ]
})
export class TodosModule { }
