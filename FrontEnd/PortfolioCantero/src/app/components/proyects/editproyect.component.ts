import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyect } from 'src/app/model/proyect';
import { ProyectService } from 'src/app/service/proyect.service';

@Component({
  selector: 'app-editproyect',
  templateUrl: './editproyect.component.html',
  styleUrls: ['./editproyect.component.css']
})
export class EditproyectComponent implements OnInit {

  proyect: Proyect = null!;

  constructor(private sProyect: ProyectService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyect.detail(id).subscribe(data => {
      this.proyect = data;
    }, err =>{
      alert("Error al cargar los proyectos");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyect.update(id, this.proyect).subscribe(data =>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar el proyecto");
      this.router.navigate(['']);
    })
  }

}
