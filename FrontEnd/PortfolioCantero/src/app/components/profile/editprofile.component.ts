import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from 'src/app/model/person';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  person: Person = null!;

  constructor(private sPerson: PersonService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPerson.detail(id).subscribe(data => {
      this.person = data;
    }, err =>{
      alert("Error al modificar el perfil");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPerson.update(id, this.person).subscribe(data =>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar el perfil");
      this.router.navigate(['']);
    })
  }

}
