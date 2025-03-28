import { NgModule } from "@angular/core";
import { NotesComponent } from "./notes/notes.component";
import { CoinsComponent } from "./coins/coins.component";
import { CommonModule } from "@angular/common";
import { DepositRoutingModule } from "./deposit-routing.module";

@NgModule({
  declarations: [
    NotesComponent,
    CoinsComponent
  ],
  imports: [
    CommonModule,
    DepositRoutingModule
  ],
  exports: [],
  providers: [] // Add any custom services or providers here
})
export class DepositModule {}
