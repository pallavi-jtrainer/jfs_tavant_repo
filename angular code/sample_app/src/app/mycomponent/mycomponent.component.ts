import { Component } from '@angular/core';

@Component({
  selector: 'app-mycomponent',
  templateUrl: './mycomponent.component.html',
  styleUrls: ['./mycomponent.component.css']
})
export class MycomponentComponent {
  //componentName = 'mycomponent';
  name:string = "";
  email: string = "";

  onSubmit() {
    console.log("Name: " + this.name + " Email: " + this.email);
  }
}
