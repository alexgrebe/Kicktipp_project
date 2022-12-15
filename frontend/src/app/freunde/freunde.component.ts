import { Component, OnInit } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';
import { FreundeService } from './freunde.service';

@Component({
  selector: 'app-freunde',
  templateUrl: './freunde.component.html',
  styleUrls: ['./freunde.component.scss']
})
export class FreundeComponent implements OnInit {

  freunde: Benutzer[];

  constructor(private service: FreundeService) { this.freunde = []; }

  ngOnInit(): void {
    this.service.getFreunde().subscribe(data => {this.freunde = data}, err => {alert("Fehler! Seite neu laden")})
  }

  deleteFreunde(id: number) { 
    if(id!==0)
    this.service.deleteFreund(id).subscribe(data => { alert("Freund gelöscht!") }, err => {alert("Fehler!")})
    else{alert("Fehler!")}
  }

}
