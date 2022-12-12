import { Component, OnInit } from '@angular/core';
import {TipprundenlisteService, TipprundenResponse} from "./tipprundenliste.service";

@Component({
  selector: 'app-tipprundenliste',
  templateUrl: './tipprundenliste.component.html',
  styleUrls: ['./tipprundenliste.component.scss']
})
export class TipprundenlisteComponent implements OnInit {

  tipprunden: TipprundenResponse[] = []
  constructor(private service: TipprundenlisteService) { }

  ngOnInit(): void {
    this.service.getAllTippspiele().subscribe((data) => {
      this.tipprunden = data
    })
  }
    tipprundeBeitreten(id: number){
    this.service.tipprundeBeitreten(id).subscribe(response => {
      console.log(response.status)
    })   }



}
