import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Spiel } from '../Models/Spiel';
import { WettenligaService } from './wettenliga.service';

@Component({
  selector: 'app-wettenliga',
  templateUrl: './wettenliga.component.html',
  styleUrls: ['./wettenliga.component.scss']
})
export class WettenligaComponent implements OnInit {

  ligaID: number | undefined;
  spiele: Spiel[];

  constructor(private service: WettenligaService, private activeRoute: ActivatedRoute) { this.spiele = []; }

  ngOnInit(): void {
    this.activeRoute.params.subscribe(data => {this.ligaID = data['id']; 
    if(this.ligaID)
    this.service.getSpiele(this.ligaID).subscribe(data => {this.spiele = data; console.log(data)})})
    
  }

}
