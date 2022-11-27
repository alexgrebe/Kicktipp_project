import {Component, OnInit} from '@angular/core';
import {Liga} from '../Models/Liga';
import {AdminligaService} from './adminliga.service';
import {Spiel} from '../Models/Spiel'

@Component({
  selector: 'app-adminliga',
  templateUrl: './adminliga.component.html',
  styleUrls: ['./adminliga.component.scss']
})
export class AdminligaComponent implements OnInit {

  liga: Liga;
  spiel: Spiel;
  reader: FileReader;
  ligaId: number;
  ligen: Liga[];
  CSVFile: File;

  constructor(private service: AdminligaService) {
    this.liga = new Liga();
    this.reader = new FileReader();
    this.reader.onloadend = () => {
      this.liga.logoID = this.reader.result + ""
    };
    this.spiel = new Spiel();
    this.ligaId = 0;
    this.ligen = [];
    this.CSVFile = new File([""], "csvname")
  }

  ngOnInit(): void {
    this.service.getLigen().subscribe(data => {
      this.ligen = data
    })
    console.log(this.ligen);
  }

  addLigaSubmit() {
    console.log(this.liga);
    this.service.addLiga(this.liga).subscribe(data => {
      console.log(data)
    })
  }

  addGameSubmit() {
    console.log(this.spiel);
    this.service.addGame(this.spiel).subscribe(data => {
      console.log(data)
    })
  }

  readInCSVSubmit() {
    console.log(this.CSVFile?.size);
    console.log(this.ligaId);
    this.service.readInCSV(this.CSVFile, this.ligaId).subscribe(data => {
      console.log(data)
    })
  }

  async logoLigaChange(e: any) {
    this.reader.readAsDataURL(e.target.files[0]);
  }

  setCSVFile(e: any) {
    this.CSVFile = e.target.files[0];
  }

}
