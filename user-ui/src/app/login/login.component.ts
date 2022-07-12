import { UserAuthService } from './../_services/user-auth.service';
import { UserService } from './../_services/user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, 
              private userAuthService: UserAuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response:any)=>{
        /**
         * set roles and token
         */
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        /** Check each user and route them depending on their roles */
        const role = response.user.role[0].roleName;
        if (role === 'Admin') {
          /** Route adming to admin pages */
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/user']);
        }
      },
      (error)=>{
        console.log(error);
      }
    );
  }
}
