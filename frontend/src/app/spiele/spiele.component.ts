import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Spiel } from '../Models/Spiel';
import { SpieleService } from './spiele.service';

@Component({
  selector: 'app-spiele',
  templateUrl: './spiele.component.html',
  styleUrls: ['./spiele.component.scss']
})
export class SpieleComponent implements OnInit {
  
  id: number;
  games: Spiel[]|undefined;

  constructor(private router: ActivatedRoute, private service: SpieleService) { this.id = 0; }

  ngOnInit(): void {
    this.router.params.subscribe(params => {this.id = params['id']})
    this.service.getAllGames(this.id).subscribe(data => {this.games = data})
  }

}
