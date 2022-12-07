import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Benutzer} from "../Models/Benutzer";

@Injectable({
  providedIn: 'root'
})
export class NutzerService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:3000/api/user/"
  }

  getNutzer(id: number) {
    return this.http.get<Benutzer>(this.url + id)
  }
}

