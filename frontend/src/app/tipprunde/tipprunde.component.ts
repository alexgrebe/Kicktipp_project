import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mitglied } from '../Models/Mitglied';
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

  constructor(private service: TipprundeService, private router: ActivatedRoute) { this.mitglieder = []; this.tipprunde = new Tipprunde(); this.mitglied = new Mitglied();}

  ngOnInit(): void {
    this.router.params.subscribe(data => { this.id = data['id']})
    if(this.id !== undefined) {
    this.service.getTipprundenInfo(this.id).subscribe(data => {this.tipprunde = data})
    this.service.getMitgliederTabelle(this.id).subscribe(data => {this.mitglieder = data;
      if(this.tipprunde.id!==undefined)
      this.service.getOwnDetails(this.tipprunde.id).subscribe( data => { this.mitglied = data })
      else{ alert(this.tipprunde.name)}
    }, err => {alert("Fehler!")}) }
    else { alert("Fehler! Seite neu laden")}
  }

  changeNameSubmit() {
    if(this.name!==undefined && this.mitglied.id!==undefined) {
      this.service.changeMitgliedName(this.name, this.mitglied.id).subscribe(data => {alert("Name geändert!")}, err => {alert("Fehler!")})
    }
  }

}
