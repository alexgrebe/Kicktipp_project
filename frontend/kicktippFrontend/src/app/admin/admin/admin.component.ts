import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/adminService/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  hallo: String;

  constructor(private service: AdminService) { this.hallo = ""; }

  ngOnInit(): void {
    this.service.findHallo().subscribe((data: String) => { console.log(data); this.hallo = data; },
      (err) => { console.log(err); })
  }

}
