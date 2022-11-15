import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { LigaComponent } from './liga/liga.component';
import { SpieleComponent } from './spiele/spiele.component';
import { NutzerguardService } from './authguards/nutzerguard.service';
import { LoginComponent } from './login/login.component';
import { AdminligaComponent } from './adminliga/adminliga.component';

const routes: Routes = [{path: 'register', component: RegisterComponent},
  {path: 'adminRegister', component: AdminRegisterComponent},
  {path: 'liga', component: LigaComponent},
  {path: 'spiele/:id', component: SpieleComponent},
  {path:'login', component: LoginComponent},
  {path: 'adminliga', component: AdminligaComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
