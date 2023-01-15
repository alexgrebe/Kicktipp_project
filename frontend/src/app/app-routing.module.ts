import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {AdminRegisterComponent} from './admin-register/admin-register.component';
import {LigaComponent} from './liga/liga.component';
import {SpieleComponent} from './spiele/spiele.component';
import {LoginComponent} from './login/login.component';
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

const routes: Routes = [
  {path: 'register', component: RegisterComponent},
  {path: 'adminRegister', component: AdminRegisterComponent},
  {path: 'liga', component: LigaComponent},
  {path: 'spiele/:id', component: SpieleComponent},
  {path: 'login', component: LoginComponent},
  {path: 'adminliga', component: AdminligaComponent},
  {path: 'config', component: ConfigComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'nutzer', component: NutzerComponent},
  {path: '', component: HomeComponent},
  {path: 'tipprundeerstellen', component: TipprundecreateComponent},
  {path: 'tipprundenanzeigen', component: TipprundenlisteComponent},
  {path: 'beitreten/:id', component: TipprundebeitretenComponent},
  {path: 'tipprunde/:id', component: TipprundeComponent},
  {path: 'soziales', component: FreundeComponent},
  {path: 'profil/:id', component: ProfilComponent},
  {path: 'tipprundenEinladung/:id', component: TipprundeneinladungComponent},
  {path: 'tipp/:id/:spielid', component: TippComponent},
  {path: 'wetten', component: WettenComponent},
  {path: 'wetteLiga/:id', component: WettenligaComponent},
  {path: 'wetteSpiel/:id', component: WettespielComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
