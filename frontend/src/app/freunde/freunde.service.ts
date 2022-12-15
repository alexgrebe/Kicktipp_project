import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';
import { Freundschaftsanfragen } from '../Models/Freundschaftsanfragen';

@Injectable({
  providedIn: 'root'
})
export class FreundeService {

  url: string;

  constructor(private http: HttpClient) { this.url="http://localhost:8080/" }

  getFreunde() { return this.http.get<Benutzer[]>(this.url+"anzeigen", {withCredentials: true})}

  deleteFreund(id: number) { return this.http.get(this.url+"delete/"+id, {withCredentials: true, responseType: 'text'})}

  getOffeneFreundschaftsanfragen() { return this.http.get<Benutzer[]>(this.url+"offeneFreundschaftsanfragen", {withCredentials: true})}

  anfrageAnnhemen(id: number) { return this.http.get(this.url+"freundschaftsanfrageAnnehmen/"+id, {withCredentials: true, responseType: 'text'}) }

  getNutzerOhneFreunde() { return this.http.get<Benutzer[]>(this.url+"nutzerOhneFreunde", {withCredentials: true})}

  freundschaftsanfrageErstellen(anfrage: Freundschaftsanfragen) { return this.http.post(this.url+"create", anfrage, {withCredentials: true, responseType: 'text'})}
}
