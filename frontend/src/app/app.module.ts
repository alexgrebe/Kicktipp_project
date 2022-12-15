import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RegisterComponent} from './register/register.component';
import {AdminRegisterComponent} from './admin-register/admin-register.component';
import {LoginComponent} from './login/login.component';
import {LigaComponent} from './liga/liga.component';
import {SpieleComponent} from './spiele/spiele.component';
import {AdminligaComponent} from './adminliga/adminliga.component';
import {ConfigComponent} from './config/config.component';
import {AdminComponent} from './admin/admin.component';
import {NutzerComponent} from './nutzer/nutzer.component';
import {HomeComponent} from './home/home.component';
import { TippspielFormComponent } from './tippspiel-form/tippspiel-form.component';
import { FreundeComponent } from './freunde/freunde.component';
import { FreundeslisteComponent } from './freundesliste/freundesliste.component';
import { TipprundenlisteComponent } from './tipprundenliste/tipprundenliste.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TipprundeAnzeigenComponent } from './tipprunde-anzeigen/tipprunde-anzeigen.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    AdminRegisterComponent,
    LoginComponent,
    LigaComponent,
    SpieleComponent,
    AdminligaComponent,
    ConfigComponent,
    AdminComponent,
    NutzerComponent,
    HomeComponent,
    TippspielFormComponent,
    FreundeComponent,
    FreundeslisteComponent,
    TipprundenlisteComponent,
    DashboardComponent,
    TipprundeAnzeigenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
