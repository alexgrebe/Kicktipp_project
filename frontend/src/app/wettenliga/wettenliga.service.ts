import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Spiel } from '../Models/Spiel';

@Injectable({
  providedIn: 'root'
})
export class WettenligaService {

  url: string = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  getSpiele(ligaID: number) {
    return this.http.get<Spiel[]>(this.url+"offeneSpieleLiga/"+ligaID, {withCredentials: true})
  }
}
