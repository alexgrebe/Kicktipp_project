import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Benutzer } from '../Models/Benutzer';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  benutzer: Benutzer;

  constructor(
    private service: LoginService,
    private router: Router
  ) {
    this.benutzer=new Benutzer()
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.login(this.benutzer).subscribe(data => { console.log(data); this.router.navigate([data]) },
      err => {console.log(err); alert("Login fehlgeschlagen!")});
  }

}
