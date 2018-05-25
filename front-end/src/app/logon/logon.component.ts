import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logon',
  templateUrl: './logon.component.html',
  providers: [AuthenticationService]
})
export class LogonComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,
              private router: Router) { }

  ngOnInit() {
  }

  onRegisterClick(cpf: string,nome: string,password: string) {
    this.authenticationService.register(cpf,nome,password).subscribe(
      response => {
        alert('Usuário criado com sucesso!')
        this.authenticationService.login(cpf,password,'')
      },
      error => alert(error.error.message)
    )
  } 

  onLoginClick() {
    this.router.navigate(['login'])
  }

}
