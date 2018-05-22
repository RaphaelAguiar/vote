import { Component, Inject } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { EleicaoService } from '../services/eleicao.service';

@Component({
  selector: 'main',
  templateUrl: './main.component.html',
  providers: [EleicaoService]
})
export class MainComponent {

  resultadoPresidente: {}
  
  constructor(private router: Router,
              private eleicaoService: EleicaoService) {
    eleicaoService.getResultado('presidente').subscribe(resultado => {
      this.resultadoPresidente = resultado;
    },error => console.log(error.error));
  }

  public onLoginClick(){
    this.router.navigate(['login']);
  }
  public onLogonClick(){
    this.router.navigate(['logon']);
  }
}
