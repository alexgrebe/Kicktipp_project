import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mitglied } from '../Models/Mitglied';
import { Spiel } from '../Models/Spiel';
import { Tipprunde } from '../Models/Tipprunde';
import { TipprundeService } from './tipprunde.service';

@Component({
  selector: 'app-tipprunde',
  templateUrl: './tipprunde.component.html',
  styleUrls: ['./tipprunde.component.scss']
})
export class TipprundeComponent implements OnInit {

  mitglieder: Mitglied[];
  tipprunde: Tipprunde;
  id: number | undefined;
  mitglied: Mitglied;
  name: string | undefined;
  nochZuSpielendeSpiele: Spiel[];

  constructor(private service: TipprundeService, private router: ActivatedRoute) { this.mitglieder = []; this.tipprunde = new Tipprunde(); this.mitglied = new Mitglied();
    this.nochZuSpielendeSpiele = [];
  }

  ngOnInit(): void {
    this.router.params.subscribe(data => { this.id = data['id']})
    if(this.id !== undefined) {
    this.service.getTipprundenInfo(this.id).subscribe(data => {this.tipprunde = data;})
    this.service.getMitgliederTabelle(this.id).subscribe(data => {this.mitglieder = data;
      if(this.tipprunde.id!==undefined && this.tipprunde.ligaID!==undefined) {
        this.service.getOffeneSpiele(this.tipprunde.id).subscribe( data => { this.nochZuSpielendeSpiele = data; console.log(data)}, err => {alert("Neu laden!")})
      this.service.getOwnDetails(this.tipprunde.id).subscribe( data => { this.mitglied = data })}
      else{ alert(this.tipprunde.name)}
    }, err => {alert("Fehler!")}) }
    else { alert("Fehler! Seite neu laden")}
  }

  changeNameSubmit() {
    if(this.name!==undefined && this.mitglied.id!==undefined) {
      this.service.changeMitgliedName(this.name, this.mitglied.id).subscribe(data => {this.service.getMitgliederTabelle(this.id ? this.id : 0).subscribe(data => this.mitglieder = data)}, 
      err => {alert("Fehler!")})
    }
  }

  checkIfBesitzer(id1: number, id2: number) {
    return id1===id2
  }

}
