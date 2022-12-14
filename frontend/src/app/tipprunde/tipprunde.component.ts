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

  constructor(private service: TipprundeService, private router: ActivatedRoute) { this.mitglieder = []; this.tipprunde = new Tipprunde();}

  ngOnInit(): void {
    this.router.params.subscribe(data => { this.id = data['id']})
    if(this.id !== undefined) {
    this.service.getTipprundenInfo(this.id).subscribe(data => {this.tipprunde = data})
    this.service.getMitgliederTabelle(this.id).subscribe(data => {this.mitglieder = data}) }
    else { alert("Fehler! Seite neu laden")}
  }

}
