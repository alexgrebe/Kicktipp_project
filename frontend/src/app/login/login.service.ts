import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url: string;
  constructor(private http: HttpClient) { this.url = "http://localhost:8080/login" }

  login(benutzer: Benutzer) {
    return this.http.post(this.url, benutzer,
      { responseType: 'text', withCredentials: true })
  }
}
