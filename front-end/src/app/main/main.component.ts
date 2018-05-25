import { Component, Inject, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { allResolved } from 'q';
import { Server } from '../services/server.service';

@Component({
  selector: 'main',
  templateUrl: './main.component.html',
  providers: [Server,AuthenticationService]
})
export class MainComponent implements OnInit {

  usuario: any = {}
  resultadoPresidente: any = {}
  candidatos: any = []
  
  constructor(private router: Router,
              private server: Server,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.carregarDadosTela();    
  }

  private carregarDadosTela(){
    if(!this.authenticationService.isLogged()){
      this.router.navigate(['login'])
    }else{
      this.server.authGet<any>(`api/eleicao/presidente`).subscribe(resultado => {
        this.resultadoPresidente = resultado
        this.server.authGetWithParams(`api/cidadao`,{cargo: 'presidente'})
          .subscribe(candidatos => this.candidatos = candidatos)
      },error => alert(error.error.message))

      this.server.authGet(`api/cidadao/${this.authenticationService.getUserCpf()}`)
        .subscribe(usuario => this.usuario = usuario)
    }
  }

  onLogoutClick() {
    this.authenticationService.logout()
    this.router.navigate(['login'])
  }

  onCanditarClick(cargo: string) {
    this.server.authPut(`api/cidadao`,{cargo: cargo}).subscribe(
      response => {
        alert('Candidatura efeturada com sucesso!')
        this.carregarDadosTela();
      },
      error => alert(error.error.message)
    )
  }
  onVotarClick(nomeCargo: string, cpfCandidato: string) {
    this.server.authPost(
      `api/eleicao`,
      {cargo: nomeCargo, cpfCandidato: cpfCandidato}
    ).subscribe(response => {
      this.carregarDadosTela();
    }, error => alert(error.error.message))
  }

  isLogged() {
    return this.authenticationService.isLogged();
  }

  getNome(cpf: string): string {
      try {
        return this.candidatos
          .filter(c => c.cpf === cpf)[0]
          .nome
      }catch(err){
        return ''
      }
  }
}
