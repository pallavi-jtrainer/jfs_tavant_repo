import { inject, Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

// @Injectable()
// export class AuthGuardService implements CanActivate {
//   canActivate(route: ActivatedRouteSnapshot,
//     state: RouterStateSnapshot
//   ): boolean {

//   }
// }

export const canActivate = (
  router: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
): boolean | UrlTree |Promise<boolean | UrlTree> | Observable<boolean | UrlTree> => {
  const authService = inject(AuthService);
  const route = inject(Router);

  if (!authService.isUserLoggedIn()) {
    console.log('You are not authorized to view this page');
    return route.navigate(['/login'], { queryParams: { returnUrl: state.url } });
  }
  return true;
}
