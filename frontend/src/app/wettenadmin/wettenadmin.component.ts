import { Component, OnInit } from '@angular/core';
import { WettenadminService } from './wettenadmin.service';
import { Benutzer } from '../Models/Benutzer';

@Component({
  selector: 'app-wettenadmin',
  templateUrl: './wettenadmin.component.html',
  styleUrls: ['./wettenadmin.component.scss']
})
export class WettenadminComponent implements OnInit {

  offene: Benutzer[] = [];

  constructor(private service: WettenadminService) { }

  ngOnInit(): void {
    this.service.getEntscheidungen().subscribe(data => {this.offene = data})
  }

  entscheidungSubmit(antwort: boolean, id: number) {this.service.setEntscheidung(id, antwort).subscribe(data => {console.log(data)
  this.service.getEntscheidungen().subscribe(data => {this.offene = data});
  })}

}
