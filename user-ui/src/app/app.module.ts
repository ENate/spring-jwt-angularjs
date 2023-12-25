import { UserService } from './_services/user.service';
import { AuthGuard } from './_auth/auth.guard';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AuthInterceptor } from './_auth/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    UserComponent,
    HeaderComponent,
    LoginComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    /** Use auth guard after defining new class interceptor in _auth */
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi:true

    }, /** provide name to use interceptor */
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
