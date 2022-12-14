import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TipprundebeitretenService } from './tipprundebeitreten.service';
import { Tipprunde } from '../Models/Tipprunde';

@Component({
  selector: 'app-tipprundebeitreten',
  templateUrl: './tipprundebeitreten.component.html',
  styleUrls: ['./tipprundebeitreten.component.scss']
})
export class TipprundebeitretenComponent implements OnInit {

  id: number | undefined;
  passwort: string | undefined;
  tipprunde: Tipprunde;

  constructor(private service: TipprundebeitretenService, private router: ActivatedRoute, private routerNavi: Router) { 
  this.tipprunde = new Tipprunde();
  this.tipprunde.passwortVorhanden = false;
  }

  ngOnInit(): void {
    this.router.params.subscribe(params => { this.id = params['id']})
    if(this.id!==undefined  )
    this.service.getTipprunde(this.id).subscribe(data => {this.tipprunde = data}, err => {alert(err)})
    else{alert("Fehler! Seite neu laden")}
  }

  beitretenSubmit() { 
    if(this.id !== undefined) {
    this.service.rundeBeitreten(this.id, this.passwort).subscribe(data => {this.routerNavi.navigate(["/tipprunde/"+this.id])},
    err => {alert('Fehler!')})}
      else{
        alert("Fehler! Seite neu laden")
      }
  }
  
  }


