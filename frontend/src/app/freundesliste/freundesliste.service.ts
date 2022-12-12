import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Liga} from '../Models/Liga';
import {Benutzer} from "../Models/Benutzer";


export interface BenutzerResponse extends Benutzer {
  id: number,
  authtoken: string,
}
@Injectable({
  providedIn: 'root'
})

export class FreundeslisteService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/freunde/anzeigen"
  }

  getFreunde() {
    return this.http.get<BenutzerResponse[]>(this.url)
  }
}
