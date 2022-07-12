import { Router } from '@angular/router';
import { UserAuthService } from './../_services/user-auth.service';
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { Injectable } from '@angular/core';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(private authUserService: UserAuthService,
                private router:Router) {}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        /** throw new Error("Method not implemented."); */
        if(req.headers.get("No-Auth") === 'True') {
            return next.handle(req.clone());
        }
        const token = this.authUserService.getToken();
        req = this.addToken(req, token);
        return next.handle(req).pipe(
            catchError(
                (err:HttpErrorResponse) => {
                    console.log(err.status);
                    if (err.status === 401) {
                        this.router.navigate(['/login']);
                    } else if (err.status === 403) {
                        this.router.navigate(['/forbidden']);
                    }
                    return throwError(() => new Error("Oops!! Something is wrong."));
                }
            )
        );

    }
    /** create new function which takes param and adds to header */
    private addToken(request:HttpRequest<any>, token:string | null) {
        return request.clone(
            {
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            }
        );
    }
    
}