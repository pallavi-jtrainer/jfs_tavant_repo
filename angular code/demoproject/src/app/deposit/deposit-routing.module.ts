import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CoinsComponent } from "./coins/coins.component";
import { NotesComponent } from "./notes/notes.component";

const routes: Routes = [
  {path: 'coins', component: CoinsComponent},
  {path: 'notes', component: NotesComponent}
];

@NgModule({
  imports:[RouterModule.forChild(routes)],
  exports:[RouterModule]
})
export class DepositRoutingModule {}
