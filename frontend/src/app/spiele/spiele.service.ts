import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Spiel} from '../Models/Spiel';

@Injectable({
  providedIn: 'root'
})
export class SpieleService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/getAllGamesByLeague/"
  }

  getAllGames(id: number): Observable<Spiel[]> {
    return this.http.get<Spiel[]>(this.url + id)
  }
}
