import { Component, OnInit } from '@angular/core';
import { Benutzer } from './Benutzer';
import { RegisterService } from 'src/app/registerService/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {

  benutzer: Benutzer;

  constructor(private service: RegisterService) { this.benutzer = new Benutzer() }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.register(this.benutzer).subscribe(data => { console.log(data) });
  }

}
