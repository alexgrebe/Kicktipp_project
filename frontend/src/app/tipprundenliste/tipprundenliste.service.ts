import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Liga} from '../Models/Liga';

export interface TipprundenResponse{

  id: number,
  ligaid: number,
  name: string,
  besitzerId: number,
  ergebnisgewicht: number,
  tordiffgewicht: number,
  siegergewicht: number,
  passwort: string,
  privat: boolean,
}

@Injectable({
  providedIn: 'root'
})

export class TipprundenlisteService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:3000/tipprundenAnzeigen"
  }

  getAllTippspiele() {
    return this.http.get<TipprundenResponse[]>(this.url)
  }

  tipprundeBeitreten(id: number){
    return this.http.post(
      "http://localhost:3000/beitreten/" + id,
      [],
      {observe:"response"})
  }
}
