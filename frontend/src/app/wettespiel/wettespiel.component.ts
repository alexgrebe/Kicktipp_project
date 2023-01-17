import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WettespielService } from './wettespiel.service';
import { Auswahl, Wette } from '../Models/Wette';
import { Quoten } from '../Models/Quoten';

@Component({
  selector: 'app-wettespiel',
  templateUrl: './wettespiel.component.html',
  styleUrls: ['./wettespiel.component.scss']
})
export class WettespielComponent implements OnInit {

  spielID: number | undefined;
  wette: Wette;
  quoten: Quoten;

  constructor(private service: WettespielService, private activeRoute: ActivatedRoute, private router: Router) { this.wette = new Wette(); this.quoten = new Quoten();}

  ngOnInit(): void {
    this.activeRoute.params.subscribe(data => {this.spielID = data['id']; 
    this.service.getQuoten(data['id']).subscribe(data => {this.quoten = data;});
    this.wette.spielID = data['id'];
  })
  }

  wetteSubmit() {
    this.service.wetteAbschließen(this.wette).subscribe(data => {this.router.navigate(['wetten']);});
  }

}
