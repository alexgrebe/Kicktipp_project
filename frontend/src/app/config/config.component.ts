import {Component, OnInit} from '@angular/core';
import {Config} from '../Models/Config';
import {ConfigService} from './config.service';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.scss']
})
export class ConfigComponent implements OnInit {

  config: Config;

  constructor(private service: ConfigService) {
    this.config = new Config();
  }

  ngOnInit(): void {
  }

  setConfigSubmit() {
    this.service.setConfig(this.config).subscribe( data => { alert("Hat geklappt") }, err => { alert(err) }) 
  }

}
