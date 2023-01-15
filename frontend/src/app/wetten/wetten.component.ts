import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Benutzer } from '../Models/Benutzer';
import { Liga } from '../Models/Liga';
import { WettenService } from './wetten.service';

@Component({
  selector: 'app-wetten',
  templateUrl: './wetten.component.html',
  styleUrls: ['./wetten.component.scss']
})
export class WettenComponent implements OnInit {

  User: Benutzer | undefined;
  Ligen: Liga[];

  constructor(private service: WettenService, private router: Router) { this.Ligen = []; }

  ngOnInit(): void {
    this.service.getUserDetails().subscribe(data => {this.User = data}, err => {this.router.navigate(['login'])})
    this.service.getLeagues().subscribe(data => {this.Ligen = data; console.log(data)}, err => {})
  }

  erlaubnisAnfragen() {
    this.service.erlaubnisAnfrage().subscribe(data => {this.router.navigate(['login'])}, err => {alert(err  )})
  }

}
