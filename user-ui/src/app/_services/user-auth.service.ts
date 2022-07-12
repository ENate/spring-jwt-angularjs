import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }
  /** Define setter to store token locally */
  /**
   * setRoles: use JSON to format array=>string
   */
  public setRoles(roles: [] ) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }
  /** Define Getter */
  /**
   * getRoles
   */
  public getRoles(): [] {
    return JSON.parse(localStorage.getItem('roles')!);
  }

  /**
   * setToken
   */
  public setToken(jwtToken:string) {
    localStorage.setItem("jwtToken", jwtToken);
  }

  /**
   * getToken
 : string  */
  public  getToken(): string | null {
    return localStorage.getItem('jwtToken');
  }

  /**
   * clear: to clear user storage
   */
  public clear() {
    localStorage.clear();
  }

  /** Returns false if user is logged out */
  /**
   * isLoggedIn
   */
  public isLoggedIn() {
    /** call and check if created token and roles functions
     * contains any values
     */
    return this.getRoles() && this.getToken();
  }

}
