import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyect } from 'src/app/model/proyect';
import { ProyectService } from 'src/app/service/proyect.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {

  proyect: Proyect[] = [];
  nombre!: string;
  descripcion!: string;
  fecha!: string;
  link!: string;

  constructor(private sProyect: ProyectService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyect();
    if(this.tokenService.getToken()){
      this.isLogged = true;      
    } else {
      this.isLogged = false;
    }
  }

  cargarProyect(): void{
    this.sProyect.list().subscribe(data =>{this.proyect = data});
  }

  delete(id: number){
    if(id != undefined){
      this.sProyect.delete(id).subscribe(data => {this.cargarProyect()}, 
      err => {
        alert("No se pudo eliminar item de proyecto"); }
      )
    }
  }

  onCreate(): void{
    const proyect = new Proyect (this.nombre, this.descripcion, this.fecha, this.link);
    this.sProyect.save(proyect).subscribe(data =>{
      alert("Proyecto creado correctamente");
      this.router.navigate(['']);
    }, err =>{
      alert("Fallo la creacion de nuevo proyecto");
      this.router.navigate(['']);
    })
  }

}
