import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { ExperienceService } from 'src/app/service/experience.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  expe: Experience[] = [];
  nombre!: string;
  descripcion!: string;
  fecha!: string;
  puesto!: string;

  constructor(private sExperience: ExperienceService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperience();  
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    } 
  }

  cargarExperience():void{
    this.sExperience.list().subscribe(data => {this.expe = data});
  } 

  delete(id: number){
    if(id != undefined){
      this.sExperience.delete(id).subscribe(data =>{
        this.cargarExperience();
      }, err => {
        alert("No se pudo eliminar la experiencia");}
      )
    }
  }

  onCreate(): void{
    const expe = new Experience(this.nombre, this.descripcion, this.fecha, this.puesto);
    this.sExperience.save(expe).subscribe(data =>{
      alert("Experiencia agregada");
      this.router.navigate(['']);      
    }, err =>{
      alert("No se pudo agregar experiencia");
      this.router.navigate(['']);
    })    
  }

}
