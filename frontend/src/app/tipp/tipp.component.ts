import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Mitglied } from '../Models/Mitglied';
import { Tipp } from '../Models/Tipp';
import { TippService } from './tipp.service';

@Component({
  selector: 'app-tipp',
  templateUrl: './tipp.component.html',
  styleUrls: ['./tipp.component.scss']
})
export class TippComponent implements OnInit {

  spielid: number | undefined;
  tipprundenid: number | undefined;
  otherTipps: Tipp[];
  tipp: Tipp;
  mitglied: Mitglied;
  checkInvite: boolean = false;

  constructor(private service: TippService, private router: ActivatedRoute, private navigator: Router) { this.otherTipps = []; this.tipp = new Tipp(); this.mitglied = new Mitglied();}

  ngOnInit(): void {
    this.router.params.subscribe(data => {this.spielid = data['spielid']; this.tipprundenid = data['id']; this.reloadFunc();}, 
    err => {alert("Fehler!")})
  }

  reloadFunc() {
    if(this.tipprundenid!==undefined && this.spielid!==undefined) {
    this.service.getOtherTipps(this.spielid).subscribe(data => {this.otherTipps = data;}, err => {alert("Fehler!")})
    this.service.getOwnDetails(this.tipprundenid).subscribe(data => {this.mitglied = data}, err => {alert("Fehler!")})
  }
    else{
      alert("Fehler!")
    }
  }

  tippErstellen() {
    this.tipp.spielID = this.spielid;
    this.tipp.mitgliedID = this.mitglied.id;
    this.service.betOnGame(this.tipp, this.checkInvite).subscribe(data => {this.navigator.navigate(['tipprunde/'+this.tipprundenid])}, err => {alert(err)});
  }

  ubernehmenSubmit(toreHeim:number, toreAus:number) {
    this.tipp.toreAus = toreAus;
    this.tipp.toreHeim = toreHeim;
    this.tippErstellen();
  }

}
