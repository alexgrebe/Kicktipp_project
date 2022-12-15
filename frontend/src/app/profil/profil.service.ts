import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class ProfilService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  getUserDetails(id: number) { return this.http.get<Benutzer>(this.url+"getUserDetails/"+id, {withCredentials: true})}
}
