import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API = "http://localhost:8081";
  /** corresponds to excluded initial paths in antMatchers */
  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );
  constructor(private httpClient: HttpClient) { }

  /** Authenticate username and password using authenticate endpont
   * created in the backend
   */
  /**
   * login
   */
  public login(loginData: any) {
    /** pass endpoint service depending where service is running */
    return this.httpClient.post(this.PATH_OF_API + "/authenticate", loginData, {headers: this.requestHeader});
  }
}
