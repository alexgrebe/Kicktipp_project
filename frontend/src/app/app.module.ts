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
import { TipprundecreateComponent } from './tipprundecreate/tipprundecreate.component';
import { TipprundenlisteComponent } from './tipprundenliste/tipprundenliste.component';
import { TipprundebeitretenComponent } from './tipprundebeitreten/tipprundebeitreten.component';
import { TipprundeComponent } from './tipprunde/tipprunde.component';
import { FreundeComponent } from './freunde/freunde.component';
import { ProfilComponent } from './profil/profil.component';
import { TipprundeneinladungComponent } from './tipprundeneinladung/tipprundeneinladung.component';
import { TippComponent } from './tipp/tipp.component';
import { WettenComponent } from './wetten/wetten.component';
import { WettenligaComponent } from './wettenliga/wettenliga.component';
import { WettespielComponent } from './wettespiel/wettespiel.component';
import { MinispielComponent } from './minispiel/minispiel.component';

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
    TipprundecreateComponent,
    TipprundenlisteComponent,
    TipprundebeitretenComponent,
    TipprundeComponent,
    FreundeComponent,
    ProfilComponent,
    TipprundeneinladungComponent,
    TippComponent,
    WettenComponent,
    WettenligaComponent,
    WettespielComponent,
    MinispielComponent,
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
