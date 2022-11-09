import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Benutzer } from '../Models/Benutzer';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  benutzer: Benutzer;
  reader: FileReader = new FileReader();
  profiledatafile: File|undefined;

  constructor(private service: RegisterService) {this.benutzer=new Benutzer() }

  ngOnInit(): void {
  }

  async dataConvert(event: any) {
    this.reader.onloadend = () => {console.log(this.reader.result); this.benutzer.profilepicturedata = this.reader.result+"";}
    this.profiledatafile = event.target.files[0];
    this.reader.readAsDataURL(event.target.files[0]);
  }

  async onSubmit(benutzerForm: NgForm) {
    this.benutzer.role = "nutzer";
    this.service.callAddUser(this.benutzer).subscribe(data => {console.log(data)})
  }

}
