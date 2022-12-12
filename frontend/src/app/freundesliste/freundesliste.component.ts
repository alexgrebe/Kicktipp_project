import { Component, OnInit } from '@angular/core';
import {BenutzerResponse, FreundeslisteService} from "./freundesliste.service";

@Component({
  selector: 'app-freundesliste',
  templateUrl: './freundesliste.component.html',
  styleUrls: ['./freundesliste.component.scss']
})
export class FreundeslisteComponent implements OnInit {

 freunde: BenutzerResponse[] = []
  constructor(private service: FreundeslisteService) { }

  ngOnInit(): void {
  this.service.getFreunde().subscribe((data)=>{
    this.freunde = data;
  })
  }

}
