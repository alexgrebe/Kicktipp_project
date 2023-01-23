import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WettespielService } from './wettespiel.service';
import { Auswahl, Wette } from '../Models/Wette';
import { Quoten } from '../Models/Quoten';
import { Benutzer } from '../Models/Benutzer';
import { Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-wettespiel',
  templateUrl: './wettespiel.component.html',
  styleUrls: ['./wettespiel.component.scss']
})
export class WettespielComponent implements OnInit {

  spielID: number | undefined;
  wette: Wette;
  quoten: Quoten;
  user: Benutzer;

  constructor(private service: WettespielService, private activeRoute: ActivatedRoute, private router: Router) { 
    this.wette = new Wette(); this.quoten = new Quoten(); this.user = new Benutzer(); this.wette.einsatz = 0;}

  ngOnInit(): void {
    this.service.getUserDetails().subscribe(data => {this.user = data;   console.log(this.user.geld)})
    this.activeRoute.params.subscribe(data => {this.spielID = data['id']; 
    this.service.getQuoten(data['id']).subscribe(data => {this.quoten = data;});
    this.wette.spielID = data['id'];
  })
  }

  wetteSubmit() {
    if(this.user!==undefined && this.user.geld!==undefined && this.wette.einsatz!==undefined) {
      if(this.user.geld>=this.wette.einsatz) {
    
    this.service.wetteAbschließen(this.wette).subscribe(data => {this.router.navigate(['wetten']);});
    }
    else {alert("Einsatz zu hoch")}
  }
  }

}
