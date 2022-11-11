import { Component, OnInit } from '@angular/core';
import { LigaService } from './liga.service';
import { Liga } from '../Models/Liga';

@Component({
  selector: 'app-liga',
  templateUrl: './liga.component.html',
  styleUrls: ['./liga.component.scss']
})
export class LigaComponent implements OnInit {

  ligen: Liga[];

  constructor(private service: LigaService) {this.ligen = new Array(); }

  ngOnInit(): void {
    this.service.getAllLeagues().subscribe(data => {console.log(data); this.ligen = data})
  }

}
