import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ProfileComponent } from './components/profile/profile.component';
import { EducationComponent } from './components/education/education.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { HysComponent } from './components/hys/hys.component';
import { LoginComponent } from './components/login/login.component';
import { FooterComponent } from './components/footer/footer.component';
import { ProyectsComponent } from './components/proyects/proyects.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor.service';
import { HomeComponent } from './components/home/home.component';
import { EditprofileComponent } from './components/profile/editprofile.component';
import { EditeducationComponent } from './components/education/editeducation.component';
import { NeweducationComponent } from './components/education/neweducation.component';
import { EditexperienceComponent } from './components/experience/editexperience.component';
import { EditproyectComponent } from './components/proyects/editproyect.component';
import { EdithysComponent } from './components/hys/edithys.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProfileComponent,
    EducationComponent,
    ExperienceComponent,
    HysComponent,
    LoginComponent,
    FooterComponent,
    ProyectsComponent,
    HomeComponent,
    EditprofileComponent,
    EditeducationComponent,
    NeweducationComponent,
    EditexperienceComponent,
    EditproyectComponent,
    EdithysComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
