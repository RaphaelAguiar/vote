
import { HttpClient } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject } from 'rxjs';
import { Server } from './server.service';

@Injectable()
export class AuthenticationService extends Server{
    constructor(private router: Router, private http: HttpClient) {
        super(http)
    }

    login(cpf: string, password: string, successPage: string) {
        this.http.post(
            'api/login',
            {cpf: cpf, password: password},
            {observe: 'response'}
        )
        .subscribe(response => {
            let auth = response.headers.get('Authorization')
            let userCpf = response.headers.get('userCpf')
            localStorage.setItem('Authorization',auth)
            localStorage.setItem('userCpf',userCpf)
            this.router.navigate([successPage])
        },error => {
            if(error.status === 403){
                alert('Usuário ou senha inválidos!')
            }else{
                alert(`Erro ${error.status}`)
            }
        })
    }

    logout() {
        localStorage.removeItem('Authorization')
        localStorage.removeItem('userCpf')
    }

    register(cpf: string, nome: string, password: string) {
        return this.http.post<any>(
            "/api/cidadao",
            {
                cpf: cpf, 
                nome: nome,
                password: password 
            })
    }

    isLogged() {
        let auth = localStorage.getItem('Authorization')
        return auth !== null && auth !== undefined
    }

    getUserCpf(){
        return localStorage.getItem('userCpf')
    }
}