import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Benutzer } from '../register/register/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url: string = "http://localhost:8080/addUser";

  constructor(private http: HttpClient) { }


  register(benutzer: Benutzer): Observable<any> {
    return this.http.post<any>(this.url, benutzer, { observe: 'body' })
  }
}
