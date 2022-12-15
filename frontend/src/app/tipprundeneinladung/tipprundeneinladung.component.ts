import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TipprundeneinladungService } from './tipprundeneinladung.service';
import { Benutzer } from '../Models/Benutzer';

@Component({
  selector: 'app-tipprundeneinladung',
  templateUrl: './tipprundeneinladung.component.html',
  styleUrls: ['./tipprundeneinladung.component.scss']
})
export class TipprundeneinladungComponent implements OnInit {

  id: number | undefined;
  nutzer: Benutzer[];

  constructor(private service: TipprundeneinladungService, private router: ActivatedRoute) { this.nutzer = [];}

  ngOnInit(): void {
    this.router.params.subscribe(data => {this.id = data['id']; 
    if(this.id!==undefined)
    this.reloadFunc(this.id)
    else{ alert("Fehler!") }
  }, 
      err => {})
  }

  reloadFunc(id: number) {
    this.service.getNutzerNotInTipprunde(id).subscribe(data => {this.nutzer = data}, err => {alert("Fehler!")})
  }

  einladungSendenFunc(id: number) {
    if(this.id!==undefined)
    this.service.einladungSenden(this.id, id).subscribe(data => {this.reloadFunc(this.id ? this.id : 0)
    alert("Einladung gesendet")
    }, 
      err => {alert("Fehler!")})
    else { alert("Fehler!") }
  }

}
