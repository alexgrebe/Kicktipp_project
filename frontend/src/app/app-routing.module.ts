import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';

const routes: Routes = [{path: 'register', component: RegisterComponent}, {path: 'adminRegister', component: AdminRegisterComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
