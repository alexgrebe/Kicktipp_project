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
  existingConfig: Config[];
  updateId: number;
  updateValue: string;

  constructor(private service: ConfigService) {
    this.config = new Config();
    this.existingConfig = [];
    this.updateId = 2;
    this.updateValue = ""
  }

  ngOnInit(): void {
    this.service.getConfig().subscribe(data => {
      this.existingConfig = data
    })
  }

  addSubmit() {
    this.service.addConfig(this.config).subscribe(data => {
      console.log(data)
    })
  }

  updateSubmit() {
    this.service.updateConfig(this.updateId, this.updateValue).subscribe(data => {
      console.log(data);
    })
  }

}
