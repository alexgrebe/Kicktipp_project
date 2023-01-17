import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Liga} from '../Models/Liga';
import {Spiel} from '../Models/Spiel';

@Injectable({
  providedIn: 'root'
})
export class AdminligaService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/"
  }

  addLiga(liga: Liga) {
    return this.http.post(this.url + "addLiga", liga, {responseType: 'text', withCredentials: true})
  }

  addGame(spiel: Spiel) {
    return this.http.post(this.url + "addGame", spiel, {responseType: 'text', withCredentials: true})
  }

  readInCSV(file: File, id: number) {
    let formData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(this.url + "readInCSV/" + id + "/", formData, {responseType: 'text', withCredentials: true})
  }

  getLigen() {
    return this.http.get<Liga[]>(this.url + "getAllLeagues", {withCredentials: true})
  }

  updateLiga(liga: Liga) { return this.http.post(this.url+"ligaUpdate", liga, {withCredentials: true, responseType: 'text'})}
}
