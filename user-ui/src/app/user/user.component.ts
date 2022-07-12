import { UserService } from './../_services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  message: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.forUser();
  }

  forUser() {
    return this.userService.forUser().subscribe(
      (response:any) => {
        console.log(response);
        this.message=response;
      }, (error:any) => {
        console.log(error);
      }
    );
  }

}
