import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class FreundeService {

  url: string;

  constructor(private http: HttpClient) { this.url="http://localhost:8080/" }

  getFreunde() { return this.http.get<Benutzer[]>(this.url+"anzeigen", {withCredentials: true})}

  deleteFreund(id: number) { return this.http.get(this.url+"delete/"+id, {withCredentials: true, responseType: 'text'})}
}
