import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Benutzer } from '../Models/Benutzer';
import { AdminRegisterService } from './admin-register.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.scss']
})
export class AdminRegisterComponent implements OnInit {

  benutzer: Benutzer;
  constructor(private service: AdminRegisterService, private router: Router) { this.benutzer = new Benutzer();}

  ngOnInit(): void {
  }

  onSubmit() {
    this.benutzer.role = "admin";
    console.log(this.benutzer)
    this.service.register(this.benutzer).subscribe(data => {console.log(data);
    if(data === "success") { this.router.navigateByUrl("/login")}
    else {alert(data)}
    });
  }

}
