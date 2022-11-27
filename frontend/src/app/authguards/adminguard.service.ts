import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {CanActivate} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminguardService implements CanActivate {

  url: string;
  loggedIn: boolean;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/getRole";
    this.loggedIn = false
  }

  canActivate(): boolean {
    this.http.get(this.url, {withCredentials: true, responseType: 'text'}).subscribe(data => {
      this.loggedIn = data === "admin"
    })
    return this.loggedIn
  }
}
