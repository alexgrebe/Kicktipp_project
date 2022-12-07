import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Liga} from '../Models/Liga';


@Injectable({
  providedIn: 'root'
})

export class FreundeslisteService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:3000/api/user/all"
  }

  getFreunde() {
    return this.http.get<number[]>(this.url)
  }
}
