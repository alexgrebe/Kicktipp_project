import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Benutzer } from '../Models/Benutzer';
import { ProfilService } from './profil.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  id: number | undefined;
  userDetails: Benutzer;

  constructor(private service: ProfilService, private router: ActivatedRoute) { this.userDetails = new Benutzer(); }

  ngOnInit(): void {
    this.router.params.subscribe(data => {this.id = data['id']; this.reloadFunc();});
  }

  reloadFunc() {
    if(this.id!==undefined){
    this.service.getUserDetails(this.id).subscribe(data => {this.userDetails = data}, err => {alert("Fehler!")})
  }
  else {alert("Fehler!")}
  }

}
