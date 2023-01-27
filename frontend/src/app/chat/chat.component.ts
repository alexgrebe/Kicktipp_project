import { Component, OnInit } from '@angular/core';
import { Chat } from '../Models/Chat';
import { ActivatedRoute, Router } from '@angular/router';
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
  sNachicht: Nachicht;
  tipprundeId: number;
  userId: number;

  constructor(private service: ChatService, private router: ActivatedRoute, private navigator: Router) {this.chat = new Chat(); this.nachichten = []; this.sNachicht = new Nachicht(); this.tipprundeId = 0; this.userId = 0}

  ngOnInit(): void {
    this.router.params.subscribe(data => {this.tipprundeId = data['tipprundeId']; 
                                          this.tipprundeId = data['userId']; 
                                          this.reloadData();
  }, 
    err => {alert("Fehler!")})
  }


  reloadData(){}
}
