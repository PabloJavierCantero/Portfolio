import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hys } from 'src/app/model/hys';
import { HysService } from 'src/app/service/hys.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hys',
  templateUrl: './hys.component.html',
  styleUrls: ['./hys.component.css']
})
export class HysComponent implements OnInit {

  hys: Hys[] = [];  
  nombre!: string;
  porcentaje!: number;

  constructor(private sHys: HysService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarHys();
    if(this.tokenService.getToken()){
      this.isLogged = true;      
    } else {
      this.isLogged = false;
    }
  }

  cargarHys(): void{
    this.sHys.list().subscribe(data =>{this.hys = data});
  }

  onCreate(): void {
    const hys = new Hys(this.nombre, this.porcentaje);
    this.sHys.save(hys).subscribe(data => {
      alert("Skill creada correctamente");
      this.router.navigate(['']);
    }, err =>{
      alert("Error al crear Skill");
      this.router.navigate(['']);
    });    
  }

  delete(id: number){
    if(id != undefined){
      this.sHys.delete(id).subscribe(data => {this.cargarHys()},
      err =>{
        alert("No se pudo borrar HyS");
      }
        )
    }
  }



}
