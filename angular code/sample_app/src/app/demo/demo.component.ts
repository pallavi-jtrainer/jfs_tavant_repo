import { Component } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent {
  fruits = [
    { id: 1, name: 'Apple', price: 100 },
    { id: 2, name: 'Banana', price: 50 },
    { id: 3, name: 'Mango', price: 150 },
    { id: 4, name: 'Grapes', price: 200 },
    { id: 5, name: 'Orange', price: 75 }
  ];

  btnText = "Show Text";
  showInfo: boolean = false;
  showColor: boolean = false;

  showData():void {
    this.showInfo = !this.showInfo;

    if(this.showInfo) {
      this.btnText = "Hide Text";
    } else {
      this.btnText = "Show Text";
    }
  }

  changeColor():void {
    this.showColor =!this.showColor;
  }
}
