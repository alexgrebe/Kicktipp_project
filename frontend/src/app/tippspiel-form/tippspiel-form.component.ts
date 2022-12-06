import { Component, OnInit } from '@angular/core';
import { Liga } from '../Models/Liga';
import { Tippspiel } from '../Models/Tippspiel';
import { TippspielFormService } from './tippspiel-form.service';

@Component({
  selector: 'app-tippspiel-form',
  templateUrl: './tippspiel-form.component.html',
  styleUrls: ['./tippspiel-form.component.scss']
})
export class TippspielFormComponent implements OnInit {

  model = new Tippspiel(
    "",
    false,
    null,
    1,
    1,
    1,
    "",
  )
  ligen : Liga[] = []
  submitted = false;

  constructor(private service: TippspielFormService) { }

  ngOnInit(): void {
    this.service.getLigen().subscribe(data => {
      this.ligen = data
    })
    console.log(this.ligen);
  }

  onSubmit(){
    console.log(this.model);
    this.submitted = true;
  }
}
