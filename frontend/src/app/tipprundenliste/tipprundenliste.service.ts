import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tipprunde } from '../Models/Tipprunde';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipprundenlisteService {

  url:string;

  constructor(private http:HttpClient) { this.url = "http://localhost:8080/"}


  getTipprunden(): Observable<Tipprunde[]> { return this.http.get<Tipprunde[]>(this.url+"tipprundenAnzeigen", {withCredentials: true}) }

  getMeineTipprunden(): Observable<Tipprunde[]> { return this.http.get<Tipprunde[]>(this.url+"meineTipprunden", {withCredentials: true}) }

  getEigeneTipprunden(): Observable<Tipprunde[]> { return this.http.get<Tipprunde[]>(this.url+"eigeneTipprunden", {withCredentials: true})}

}
