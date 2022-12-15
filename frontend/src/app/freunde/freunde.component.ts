import { Component, OnInit } from '@angular/core';
import { Benutzer } from '../Models/Benutzer';
import { Freundschaftsanfragen } from '../Models/Freundschaftsanfragen';
import { FreundeService } from './freunde.service';

@Component({
  selector: 'app-freunde',
  templateUrl: './freunde.component.html',
  styleUrls: ['./freunde.component.scss']
})
export class FreundeComponent implements OnInit {

  freunde: Benutzer[];
  offeneFreundschaftsanfragen: Benutzer[];
  nutzerOhneFreunde: Benutzer[];
  anf: Freundschaftsanfragen;
  suche: string | undefined;

  constructor(private service: FreundeService) { this.freunde = []; this.offeneFreundschaftsanfragen= []; this.nutzerOhneFreunde=[]; this.anf = new Freundschaftsanfragen();}

  ngOnInit(): void {
    this.reloadData();
  }

  deleteFreunde(id: number) { 
    if(id!==0) 
      this.service.deleteFreund(id).subscribe(data => { 
      this.reloadData();
    }, err => {alert("Fehler!")})
    else{alert("Fehler!")}
  }

  anfrageAnnehmen(id: number) { 
    if(id !== 0) {
      this.service.anfrageAnnhemen(id).subscribe(data => {
      this.reloadData();
    }, err => {alert("Fehler!")}) 
    }
    else{alert("Fehler!")}
  }

  anfrageErstellen(id: number) {
    if(id!==0) {
      this.anf.empfanger=id;
      this.service.freundschaftsanfrageErstellen(this.anf).subscribe(data => {this.reloadData()}, 
        err => {alert("Fehler!")});
  }
}

  suchLeisteOnChange(e: any) { this.suche = e ? e.target.value : undefined; console.log(this.suche) }

  reloadData() {
    this.service.getFreunde().subscribe(data => {this.freunde = data}, err => {alert("Fehler! Seite neu laden")})
    this.service.getOffeneFreundschaftsanfragen().subscribe(data => {this.offeneFreundschaftsanfragen = data}, err => {alert("Fehler! Seite neu laden")})
    this.service.getNutzerOhneFreunde().subscribe(data => {this.nutzerOhneFreunde=data;}, err => {alert("Fehler!")})
  }

  checkLenOfOffeneFreunde(): boolean { return this.offeneFreundschaftsanfragen.length>0}

  checkLenOfFreunde(): boolean { return this.freunde.length>0}

  checkLenOfNutzer(): boolean { return this.nutzerOhneFreunde.length>0}

  searchNutzerByName(ref: Benutzer): boolean { 
    let a = ref.vorname + " " + ref.nachname;
    a = a.toLowerCase();
    if(this.suche === undefined || this.suche === "") return true;
      return a.includes(this.suche.toLowerCase()); }

}
