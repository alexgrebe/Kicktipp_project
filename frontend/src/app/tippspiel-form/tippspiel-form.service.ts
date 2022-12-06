import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Liga} from '../Models/Liga';

@Injectable({
  providedIn: 'root'
})
export class TippspielFormService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/getAllLeagues"
  }

  getLigen() {
    return this.http.get<Liga[]>(this.url)
  }
}
