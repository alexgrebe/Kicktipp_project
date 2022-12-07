import { Component, OnInit } from '@angular/core';
import {FreundeslisteService} from "./freundesliste.service";

@Component({
  selector: 'app-freundesliste',
  templateUrl: './freundesliste.component.html',
  styleUrls: ['./freundesliste.component.scss']
})
export class FreundeslisteComponent implements OnInit {

 friendIds: number[] = []
  constructor(private service: FreundeslisteService) { }

  ngOnInit(): void {
  this.service.getFreunde().subscribe((data)=>{
    this.friendIds = data;
  })
  }

}
