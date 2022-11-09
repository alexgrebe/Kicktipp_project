import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class AdminRegisterService {

  url: string;
  constructor(private http: HttpClient) { this.url = "http://localhost:8080/addUser"}

  register(benutzer: Benutzer): Observable<any> { return this.http.post(this.url, benutzer)}
}
