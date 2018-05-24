import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class Server {
    constructor(private _http: HttpClient) { }

    authGet<T>(url: string) : Observable<T> {
        return this.authGetWithParams<T>(url, {})
    }

    authGetWithParams<T>(url: string, params: any){
        return this._http.get<T>(url,{headers: this.getHeaders(), params: params});
    }

    authPut<T>(url: string, body: any) {
        return this._http.put<T>(url,body,{headers: this.getHeaders()})
    }

    authPost<T>(url: string, body: any) {
        return this._http.post<T>(url,body,{headers: this.getHeaders()})
    }

    private getHeaders(): HttpHeaders{ 
        return new HttpHeaders({
            'Authorization': localStorage.getItem('Authorization')
        });
    }
}