import { Injectable } from "@angular/core";
import { BaseService } from "./base.service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class EleicaoService extends BaseService {
    constructor(private http: HttpClient) {
        super(http);
    }


    getResultado(cargo: string): Observable<any> {
        return this.authGet(`/api/eleicao/${cargo}`)
    }
    
}