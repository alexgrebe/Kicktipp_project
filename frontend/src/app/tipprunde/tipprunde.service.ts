import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mitglied } from '../Models/Mitglied';
import { Tipprunde } from '../Models/Tipprunde';

@Injectable({
  providedIn: 'root'
})
export class TipprundeService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  getMitgliederTabelle(tipprundenID: number) { return this.http.get<Mitglied[]>(this.url+"tipprunde/"+tipprundenID, {withCredentials: true})}

  getTipprundenInfo(tipprundenID: number) { return this.http.get<Tipprunde>(this.url+"getTipprundenInfo/"+tipprundenID, {withCredentials: true})}
}
