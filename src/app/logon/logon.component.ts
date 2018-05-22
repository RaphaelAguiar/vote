import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-logon',
  templateUrl: './logon.component.html',
  providers: [AuthenticationService]
})
export class LogonComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  onRegisterClick(cpf: string,password: string) {
    this.authenticationService.register(cpf,password).subscribe(
      response => this.authenticationService.login(cpf,password),
      error => alert(error.error.message)
    )
  } 

}
