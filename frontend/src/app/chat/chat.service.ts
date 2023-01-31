import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Chat} from '../Models/Chat';
import {Nachicht} from '../Models/Nachicht';
@Injectable({
  providedIn: 'root'
})
export class ChatService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/"
  }

  getPrivateChatMessages(friendId: number) {
    return this.http.get<Nachicht[]>(
      this.url + "getPrivateChatMessages/" + friendId,
      {withCredentials: true})
  }

  getPrivateChat(friendId: number) {
    return this.http.get<Chat>(
      this.url + "getPrivateChat/" + friendId,
      {withCredentials: true})
  }

  getTipprundeChatMessages(tipprundeId: number) {
    return this.http.get<Nachicht[]>(
      this.url + "getTipprundeChatMessages/" + tipprundeId,
      {withCredentials: true})
  }

  getTipprundeChat(tipprundeId: number) {
    return this.http.get<Chat>(
      this.url + "getTipprundeChat/" + tipprundeId,
      {withCredentials: true})
  }

  getLastMessageTime() {
    return this.http.get<Nachicht>(
      this.url + "getLastMessageTime",
      {withCredentials: true})
  }

  sendMessage(nachicht: Nachicht) {
    return this.http.post(
      this.url + "sendMessage", nachicht,
      {withCredentials: true})
  }

}
