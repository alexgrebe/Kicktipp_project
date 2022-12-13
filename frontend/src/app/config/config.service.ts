import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Config} from '../Models/Config';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/"
  }

  setConfig(config: Config) {
    return this.http.post(this.url+"updateSysTime", config, {responseType: 'text', withCredentials: true})
  }
}
