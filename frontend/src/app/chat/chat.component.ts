import { Component, OnInit } from '@angular/core';
import { Chat } from '../Models/Chat';
import { ActivatedRoute, Router } from '@angular/router';
import { interval } from 'rxjs';
import { Nachicht } from '../Models/Nachicht';
import { ChatService } from './chat.service';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {

  chat: Chat;
  nachichten: Nachicht[];
  sendNachicht: Nachicht;
  tipprundeId: number;
  userId: number;

  lastMessageTime: number | undefined;

  constructor(private service: ChatService, private router: ActivatedRoute, private navigator: Router) {
    this.chat = new Chat();
    this.nachichten = []; 
    this.sendNachicht = new Nachicht(); 
    this.tipprundeId = 0; this.userId = 0; 
    this.lastMessageTime = 0;
  }

  ngOnInit(): void {
    this.router.params.subscribe(data => {this.tipprundeId = data['tipprundeId']; 
                                          this.tipprundeId = data['userId']; 
  }, 
    err => {alert("Fehler!")});

    this.getChat();

    interval(1000).subscribe(x => {
      var tempLastMessageTime: number = Number(this.lastMessageTime) ;
      console.log(this.lastMessageTime);
      this.service.getLastMessageTime().subscribe(data => {this.lastMessageTime = data.time}, err => {alert("Fehler! Seite neu laden")}); 
      console.log("sdfasdfgasdf1231231");
      if (this.sendNachicht.time === tempLastMessageTime) {
        console.log("sdfasdfgasdf");
        this.reloadData();
        window.location.reload();
      }
  });
  }


  reloadData(){
    if (this.router.snapshot.url[0].toString()==="chatTipprunde") {
      this.service.getTipprundeChatMessages(this.tipprundeId).subscribe(data => {this.nachichten = data}, err => {alert("Fehler! Seite neu laden")});
    } else {
      this.service.getPrivateChatMessages(this.userId).subscribe(data => {this.nachichten = data}, err => {alert("Fehler! Seite neu laden")});
    }
  }

  getChat(){
    if (this.router.snapshot.url[0].toString()==="chatTipprunde") {
      this.service.getTipprundeChat(this.tipprundeId).subscribe(data => {this.chat = data}, err => {alert("Fehler! Seite neu laden")});
    } else {
      this.service.getPrivateChat(this.userId).subscribe(data => {this.chat = data}, err => {alert("Fehler! Seite neu laden")});
    }
  }

  sendMessage() {
    console.log(this.sendNachicht);
    console.log(this.chat)
    this.service.sendMessage(this.sendNachicht).subscribe(data => {
      console.log(data)
    },
    err => {
      alert(err)
    })
  }
}
