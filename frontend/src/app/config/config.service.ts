import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from '../Models/Config';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  url:string;
  constructor(private http: HttpClient) { this.url="http://localhost:8080/"}

  addConfig(config:Config) { return this.http.post(this.url+"addConfigAttribute", config, {responseType: 'text', withCredentials: true})}

  getConfig() { return this.http.get<Config[]>(this.url+"getConfigAttributes")}

  updateConfig(id:number, value: string) { return this.http.post(this.url+"updateConfig/"+id, value, {responseType: 'text', withCredentials: true})}
}
