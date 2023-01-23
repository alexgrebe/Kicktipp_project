import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quoten } from '../Models/Quoten';
import { Wette } from '../Models/Wette';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class WettespielService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  getQuoten(spielID: number) { return this.http.get<Quoten>(this.url+"getQuotenForGame/"+spielID, {withCredentials: true}) }

  wetteAbschließen(wette: Wette) { return this.http.post(this.url+"createWette", wette, {withCredentials: true, responseType: 'text'})}

  getUserDetails() { return this.http.get<Benutzer>(this.url+"getUserDetails", {withCredentials: true})}
}
