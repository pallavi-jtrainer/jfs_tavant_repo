import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent {
  constructor(private router: Router, private route: ActivatedRoute) {}

  goToCoins() {
    this.router.navigate(['coins'], {relativeTo: this.route});
    // this.router.navigate(['coins']);
  }

  goToNotes() {
    this.router.navigate(['notes'], {relativeTo: this.route});
    // this.router.navigate(['notes']);
  }
}
