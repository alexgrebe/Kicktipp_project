import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Benutzer } from '../Models/Benutzer';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  benutzer: Benutzer;
  reader: FileReader = new FileReader();
  profiledatafile: File|undefined;

  constructor() {this.benutzer=new Benutzer() }

  ngOnInit(): void {
  }

  async dataConvert(event: any) {
    this.reader.onloadend = () => {console.log(this.reader.result); this.benutzer.profilpicturedata = this.reader.result+"";}
    this.profiledatafile = event.target.files[0];
    this.reader.readAsDataURL(event.target.files[0]);
  }

  async onSubmit(benutzerForm: NgForm) {
    console.log(this.benutzer)
    console.log(benutzerForm.value)
  }

}
