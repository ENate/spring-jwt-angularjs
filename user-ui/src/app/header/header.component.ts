import { UserService } from './../_services/user.service';
import { Router } from '@angular/router';
import { UserAuthService } from './../_services/user-auth.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userAuthService: UserAuthService, 
              private router: Router,
              private userService: UserService) { }

  ngOnInit(): void {
  }

  /** returns same output as isLoggedIn function
   * in userAuthService
   */
  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }

  public set setUserService(newValue: any) {
    this.userService = newValue;
  }
  
  public get getUserService(): any {
    return this.userService;
  }
}
