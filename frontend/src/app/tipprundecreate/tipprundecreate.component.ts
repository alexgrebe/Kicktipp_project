import { Component, OnInit } from '@angular/core';
import { Liga } from '../Models/Liga';
import { Tipprunde } from '../Models/Tipprunde';
import { TipprundecreateService } from './tipprundecreate.service';

@Component({
  selector: 'app-tipprundecreate',
  templateUrl: './tipprundecreate.component.html',
  styleUrls: ['./tipprundecreate.component.scss']
})
export class TipprundecreateComponent implements OnInit {

  tipprunde: Tipprunde;
  ligen: Liga[];

  constructor(private service: TipprundecreateService) { this.tipprunde = new Tipprunde; this.ligen = []}

  ngOnInit(): void {
    this.service.getLigen().subscribe(data => {this.ligen = data})
  }

  createSubmit() { this.service.tipprundeErstellen(this.tipprunde).subscribe(data => {alert("Erstellt!")}, err => {alert(err)}); console.log(this.tipprunde) }

}
