import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-neweducation',
  templateUrl: './neweducation.component.html',
  styleUrls: ['./neweducation.component.css']
})
export class NeweducationComponent implements OnInit {

  nombre!: string;
  titulo!: string;
  fecha!: string;
  descripcion!: string;

  constructor(private sEducation: EducationService, private router: Router) { }

  ngOnInit(): void {
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
