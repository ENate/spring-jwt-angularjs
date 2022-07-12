import { UserAuthService } from './user-auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API = "http://localhost:8081";
  /** corresponds to excluded initial paths in antMatchers */
  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  );
  constructor(private httpClient: HttpClient,
    private userAuthService: UserAuthService) { }

  /** Authenticate username and password using authenticate endpont
   * created in the backend
   */
  /**
   * login
   */
  public login(loginData: any) {
    /** pass endpoint service depending where service is running */
    return this.httpClient.post(this.PATH_OF_API + "/authenticate", loginData, { headers: this.requestHeader });
  }

  public forUser() {
    return this.httpClient.get(this.PATH_OF_API + '/forUser', {responseType: 
      'text'});
  }

  public forAdmin() {
    return this.httpClient.get(this.PATH_OF_API + '/forAdmin', {responseType: 
      'text'});
  }
  /**
   * rolesMatch
allowedRoles   */
  public rolesMatch(allowedRoles:any): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();
    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          /**rolename matches allowed roless... */
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
    return isMatch;
  }
}
