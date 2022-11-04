import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  url: String;
  constructor(private http: HttpClient) { this.url = "http://localhost:8080"; }

  findHallo(): Observable<any> { return this.http.get(this.url + "", { responseType: 'text' }) }
}
