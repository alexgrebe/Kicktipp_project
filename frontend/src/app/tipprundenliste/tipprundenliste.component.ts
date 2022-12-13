import { Component, OnInit } from '@angular/core';
import { Tipprunde } from '../Models/Tipprunde';
import { TipprundenlisteService } from './tipprundenliste.service';

@Component({
  selector: 'app-tipprundenliste',
  templateUrl: './tipprundenliste.component.html',
  styleUrls: ['./tipprundenliste.component.scss']
})
export class TipprundenlisteComponent implements OnInit {

  tipprunden: Tipprunde[];
  meineTipprunden: Tipprunde[];
  eigeneTipprunden: Tipprunde[];

  constructor(private service: TipprundenlisteService) { this.tipprunden = []; this.meineTipprunden=[]; this.eigeneTipprunden = []; }

  ngOnInit(): void {
    this.service.getTipprunden().subscribe( data => {this.tipprunden = data})
    this.service.getMeineTipprunden().subscribe( data => {this.meineTipprunden = data})
    this.service.getEigeneTipprunden().subscribe( data => {this.eigeneTipprunden = data})
  }

}
