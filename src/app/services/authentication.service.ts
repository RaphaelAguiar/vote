
import { HttpClient } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Server } from './server.service';

@Injectable()
export class AuthenticationService{
    constructor(private router: Router, private http: HttpClient) {
    }

    async login(cpf: string, password: string, successPage: string) {
        this.http.post(
            'api/login',
            {cpf: cpf, password: password},
            {observe: 'response'}
        )
        .subscribe(response => {
            let auth = response.headers.get('Authorization')
            localStorage.setItem('Authorization',auth)
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
        localStorage.removeItem('Authorization');
    }

    register(cpf: string, password: string) {
        return this.http.post<any>("/api/cidadao",{cpf: cpf, password: password });
    }

    isLogged() {
        let auth = localStorage.getItem('Authorization')
        return auth !== null && auth !== undefined
    }
}