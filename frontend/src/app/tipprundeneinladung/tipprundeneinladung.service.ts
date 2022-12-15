import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';

@Injectable({
  providedIn: 'root'
})
export class TipprundeneinladungService {

  url: string;

  constructor(private http: HttpClient) { this.url="http://localhost:8080/" }

  getNutzerNotInTipprunde(id:number) { return this.http.get<Benutzer[]>(this.url+"getNutzerNotInTipprunde/"+ id, {withCredentials: true})}

  einladungSenden(tipprundenid: number, id: number) { return this.http.get(this.url+"sendInvite/"+tipprundenid+"/"+id, {withCredentials: true, responseType: 'text'})}
}
