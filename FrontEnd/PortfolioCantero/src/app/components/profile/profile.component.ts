import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from 'src/app/model/person';
import { PersonService } from 'src/app/service/person.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  person: Person[] = [];
  fullname!: string;
  imgPerfil!: string;
  posicion!: string;
  ubicacion!: string;
  contacto!: string;
  interes!: string;
  acercade!: string;
  
  
  

  constructor(private sPerson: PersonService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;  

  ngOnInit(): void {
    this.cargarPerson();
    if(this.tokenService.getToken()){
      this.isLogged = true;      
    } else {
      this.isLogged = false;
    }
  }

  cargarPerson(): void{
    this.sPerson.list().subscribe(data =>{this.person = data});
  }

  delete(id: number){
    if(id != undefined){
      this.sPerson.delete(id).subscribe(data => 
        {this.cargarPerson()},
      err =>{
        alert("No se pudo borrar Persona");
      }
        )
    }
  }

  onCreate(): void{
    const person = new Person(this.fullname, this.imgPerfil, this.posicion, this.ubicacion, this.contacto, this.interes, this.acercade);
    this.sPerson.save(person).subscribe(data => {
     alert("Persona creada correctamente");
     this.router.navigate(['']);
  }, err => {
    alert("Fallo la creacion de Persona");
    this.router.navigate(['']);
  })
  }

  

}
