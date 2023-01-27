import { Component, OnInit } from '@angular/core';
import { Wetterlaubnis } from '../Models/Wetterlaubnis';
import { AdminwettenService } from './adminwetten.service';

@Component({
  selector: 'app-adminwetten',
  templateUrl: './adminwetten.component.html',
  styleUrls: ['./adminwetten.component.scss']
})
export class AdminwettenComponent implements OnInit {

  erlaubnisse: Wetterlaubnis[];

  constructor(private service: AdminwettenService) { this.erlaubnisse = []; }

  ngOnInit(): void {
    this.service.getErlaubnis().subscribe(data => { this.erlaubnisse = data })
  }

}
