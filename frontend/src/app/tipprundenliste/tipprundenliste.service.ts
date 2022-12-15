import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import{Tippspiel} from "../Models/Tippspiel";

export interface TipprundenResponse extends Tippspiel{
  id: number,
  besitzerId: number,
}

@Injectable({
  providedIn: 'root'
})

export class TipprundenlisteService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/tipprundenAnzeigen"
  }

  getAllTippspiele() {
    return this.http.get<TipprundenResponse[]>(this.url)
  }

  tipprundeBeitreten(id: number){
    return this.http.post(
      "http://localhost:8080/beitreten/" + id,
      [],
      {observe:"response"})
  }
}
