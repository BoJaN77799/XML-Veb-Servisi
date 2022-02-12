import { Injectable,  } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Saglasnost } from '../models/Saglasnost';


@Injectable({
  providedIn: 'root'
})
export class ConsentService {

  private headers = new HttpHeaders({ "Content-Type": "application/xml"});

  constructor(private http: HttpClient) {}

  createConsent(saglasnost: Saglasnost): Observable<HttpResponse<string>> {
    var o2x = require('object-to-xml');
    console.log(o2x(saglasnost));
    let queryParams = {};
    queryParams = {
      headers: this.headers, 
      observe: "response",
      responseType: "text"
    };
    return this.http.post<HttpResponse<string>>("indirekcija/api/saglasnost/kreirajNovuSaglasnost", 
    o2x(saglasnost), queryParams);
  }
}
