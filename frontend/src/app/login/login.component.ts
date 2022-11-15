import { Component, OnInit } from '@angular/core';
import {Benutzer} from "../Models/Benutzer";
import {LoginService} from "./login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  benutzer: Benutzer;

  constructor(private service: LoginService) {
    this.benutzer=new Benutzer()
  }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.login(this.benutzer.email, this.benutzer.passwort).subscribe()
  }

}
