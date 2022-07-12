import { UserService } from './../_services/user.service';
import { UserAuthService } from './../_services/user-auth.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  /** inject a userAuthService */
  constructor(private userAuthService: UserAuthService,
              private router: Router,
              private userService: UserService) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      if (this.userAuthService.getToken() !== null) {
        /** collect data via array stored in local storage
         * Array is collect by role
         */
        const role = route.data['roles'] as Array<string>;
        if (role) {
          const match = this.userService.rolesMatch(role);

          if (match) {
            return true;
          } else {
            this.router.navigate(['/forbidden']);
            return false;
          }
        }
      }
      this.router.navigate(['/login']);
      return false;
  }
  /** determines whether user accesses a particular resource or not via matching
   * We inject a user auth service using a constructor
   */

  
}
