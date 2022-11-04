import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin/admin.component';
import { AdminService } from '../adminService/admin.service';
import { HttpClient } from '@angular/common/http';


@NgModule({
  declarations: [

    AdminComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [
    AdminService,
    HttpClient
  ]
})
export class AdminModule { }
