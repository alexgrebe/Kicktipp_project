import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tipprunde } from '../Models/Tipprunde';
import { Liga } from '../Models/Liga';

@Injectable({
  providedIn: 'root'
})
export class TipprundecreateService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  tipprundeErstellen(tipprunde: Tipprunde) { return this.http.post(this.url+"createTipprunde", tipprunde, {withCredentials: true, responseType: 'text'}) }

  getLigen() { return this.http.get<Liga[]>(this.url+"getAllLeagues", {withCredentials: true}) }
}
