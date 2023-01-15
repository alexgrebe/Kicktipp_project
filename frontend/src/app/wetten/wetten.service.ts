import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';
import { Liga } from '../Models/Liga';

@Injectable({
  providedIn: 'root'
})
export class WettenService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"; }

  getUserDetails() { return this.http.get<Benutzer>(this.url+"getUserDetails", {withCredentials:true})}

  getLeagues() { return this.http.get<Liga[]>(this.url+"getAllLeagues", {withCredentials: true}) }

  erlaubnisAnfrage() { return this.http.get(this.url+"erlaubnis", {withCredentials: true, responseType: 'text'})}
}
