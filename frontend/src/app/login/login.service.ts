import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url: string;


  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  login(email:String|any, passwort:String|any) {
    return this.http.post<Benutzer>(
      this.url+"login",
      { email: email, passwort: passwort },{})
  }
}

