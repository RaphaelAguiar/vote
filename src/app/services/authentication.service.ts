
import { HttpClient } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient,
                private router: Router) { }

    login(cpf: string, password: string) {
        localStorage.setItem("userCpf",cpf);
        localStorage.setItem("userPassword",password);
    }

    logout() {
        localStorage.removeItem("userCpf");
        localStorage.removeItem("userPassword");
    }

    register(cpf: string, password: string) {
        return this.http.post<any>("/api/cidadao",{cpf: cpf, password: password });
    }
}