import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mitglied } from '../Models/Mitglied';
import { Tipp } from '../Models/Tipp';

@Injectable({
  providedIn: 'root'
})
export class TippService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  betOnGame(tipp: Tipp) { return this.http.post(this.url+"tippErstellen/", tipp, {withCredentials: true, responseType: 'text'})}

  getOtherTipps(spielid: number) { return this.http.get<Tipp[]>(this.url+"getMyTippsForGame/"+spielid, {withCredentials: true}) }

  getOwnDetails(tipprundenID: number) { return this.http.get<Mitglied>(this.url+"getOwnMitgliedDetails/"+tipprundenID, {withCredentials: true})}
}
