import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { HttpClientModule } from '@angular/common/http';
import { LogonComponent } from './logon/logon.component';

const appRoutes: Routes = [
  { path: '' , component: MainComponent},
  { path: 'login', component: LoginComponent },
  { path: 'logon', component: LogonComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    LogonComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }



