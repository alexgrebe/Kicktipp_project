import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tipprunde } from '../Models/Tipprunde';

@Injectable({
  providedIn: 'root'
})
export class TipprundebeitretenService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  rundeBeitreten(id: number, passwort: string | undefined) { return this.http.post(this.url+"beitreten/"+id, passwort, {responseType: 'text', withCredentials: true}) }

  getTipprunde(id: number) { return this.http.get<Tipprunde>(this.url+"getTipprundenInfo/"+id, {withCredentials: true})}
}
