import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Wetterlaubnis } from '../Models/Wetterlaubnis';

@Injectable({
  providedIn: 'root'
})
export class AdminwettenService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/" }

  getErlaubnis() { return this.http.get<Wetterlaubnis[]>(this.url + "findAllErlaubnis", { withCredentials: true }) }
}
