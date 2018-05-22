import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export abstract class BaseService {
    constructor(private _http: HttpClient) { }

    authGet<T>(url: string) : Observable<T> {
        let headers = new HttpHeaders();
        let username = localStorage.getItem('userCpf');
        let password = localStorage.getItem('userPassword');
        headers.append('Authorization',`Basic ${btoa(username + ":" + password)}`)
        return this._http.get<T>(url,{headers: headers});
    }
}