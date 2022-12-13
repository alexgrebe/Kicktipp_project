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
  {path: '', component: HomeComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
