import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmDashboardComponent } from './components/adm-dashboard/adm-dashboard.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';


//Definir todas as pages/components que criei/allow access of each page created from URL
const routes: Routes = [{path:'login',component:LoginComponent},{path:'register',component:RegisterComponent},
{path:'home',component:DashboardComponent},{path:'admhome',component:AdmDashboardComponent},
{path:'',redirectTo:'login',pathMatch:"full"},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
