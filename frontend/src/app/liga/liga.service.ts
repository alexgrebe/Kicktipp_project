import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Liga} from '../Models/Liga';

@Injectable({
  providedIn: 'root'
})
export class LigaService {

  url: String;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/"
  }

  getAllLeagues(): Observable<Liga[]> {
    return this.http.get<Liga[]>(this.url + "getAllLeagues")
  }
}
