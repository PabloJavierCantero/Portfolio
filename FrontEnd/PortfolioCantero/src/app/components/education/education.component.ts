import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  education: Education[] = [];
  nombre!: string;
  descripcion!: string;
  fecha!: string;
  titulo!: string;

  constructor(private sEducation: EducationService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarEducation();
    if(this.tokenService.getToken()){
      this.isLogged = true;      
    } else {
      this.isLogged = false;
    }
  }

  cargarEducation(): void {
    this.sEducation.list().subscribe(data =>{this.education = data;})
  }

  delete(id: number){
    if(id != undefined){
      this.sEducation.delete(id).subscribe(data => {this.cargarEducation()}, 
      err => {
        alert("No se pudo eliminar item de educacion"); }
      )
    }
  }

  onCreate(): void{
    const education = new Education(this.nombre, this.descripcion, this.fecha, this.titulo);
    this.sEducation.save(education).subscribe(data =>{
      alert("Educacion creada correctamente");
      this.router.navigate(['']);
    }, err =>{
      alert("Fallo la creacion de nueva educacion");
      this.router.navigate(['']);
    })
  }

}
