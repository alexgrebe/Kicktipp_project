import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MinispielService {

  url: string;

  constructor(private http: HttpClient) { this.url = "http://localhost:8080/"}

  addGeld(geld: number) { return this.http.get(this.url+"addGeld?geld="+geld, {withCredentials: true, responseType: 'text'}) }
}
