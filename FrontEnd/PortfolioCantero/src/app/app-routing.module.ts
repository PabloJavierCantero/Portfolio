import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditeducationComponent } from './components/education/editeducation.component';
import { EditexperienceComponent } from './components/experience/editexperience.component';
import { HomeComponent } from './components/home/home.component';
import { EdithysComponent } from './components/hys/edithys.component';
import { LoginComponent } from './components/login/login.component';
import { EditprofileComponent } from './components/profile/editprofile.component';
import { EditproyectComponent } from './components/proyects/editproyect.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'editedu/:id', component: EditeducationComponent},
  {path: 'editexp/:id', component: EditexperienceComponent},
  {path: 'editproyect/:id', component: EditproyectComponent},
  {path: 'editprofile/:id', component: EditprofileComponent},
  {path: 'login', component: LoginComponent},
  {path: 'edithys/:id', component: EdithysComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
