import {Component, Input, OnInit} from '@angular/core';
import {NutzerService} from "./nutzer.services";
import {Benutzer} from "../Models/Benutzer";

@Component({
  selector: 'app-nutzer',
  templateUrl: './nutzer.component.html',
  styleUrls: ['./nutzer.component.scss']
})
export class NutzerComponent implements OnInit {

  @Input() friendId!: number;
  vorname: string = "";
  nachname: string = "";

  constructor(private service :NutzerService) {
  }

  ngOnInit()
  : void {
    this.service.getNutzer(this.friendId).subscribe((data: Benutzer)=>{
      this.vorname = data.vorname;
      this.nachname = data.nachname;
    })
  }

}
