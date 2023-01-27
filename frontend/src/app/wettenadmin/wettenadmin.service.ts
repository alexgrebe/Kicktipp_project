import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class WettenadminService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  getEntscheidungen() {return this.http.get<Benutzer[]>(this.url+"getAllErlaubnis", {withCredentials: true})}

  setEntscheidung(id: number, antwort: boolean) { return this.http.get(this.url+"entscheidungByBenutzer/"+id+"?entscheidung="+antwort, {withCredentials: true, responseType: 'text'}) }
}
