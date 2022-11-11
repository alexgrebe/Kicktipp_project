import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { LigaComponent } from './liga/liga.component';

const routes: Routes = [{path: 'register', component: RegisterComponent}, {path: 'adminRegister', component: AdminRegisterComponent}, {path: 'liga', component: LigaComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
