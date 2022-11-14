import { Component, OnInit } from '@angular/core';
import { Liga } from '../Models/Liga';
import { AdminligaService } from './adminliga.service';
import { Spiel } from '../Models/Spiel'

@Component({
  selector: 'app-adminliga',
  templateUrl: './adminliga.component.html',
  styleUrls: ['./adminliga.component.scss']
})
export class AdminligaComponent implements OnInit {

  liga: Liga;
  spiel: Spiel;
  reader: FileReader;
  ligaId: number|undefined;
  ligen: Liga[];
  CSVFile: File|undefined;

  constructor(private service: AdminligaService) { 
  this.liga = new Liga(); this.reader = new FileReader(); this.reader.onloadend = () => {this.liga.logoID = this.reader.result+""};
  this.spiel = new Spiel(); this.ligaId=0; this.ligen = []; 
  }

  ngOnInit(): void {
    this.service.getLigen().subscribe(data => {this.ligen = data})
    console.log(this.ligen);
  }

  addLigaSubmit() { console.log(this.liga); this.service.addLiga(this.liga).subscribe(data => {console.log(data)})}

  addGameSubmit() { console.log(this.spiel); this.service.addGame(this.spiel).subscribe(data => {console.log(data)})}

  readInCSVSubmit() { console.log(this.CSVFile) }

  async logoLigaChange(e: any) {
    this.reader.readAsDataURL(e.target.files[0]);
  }

}
