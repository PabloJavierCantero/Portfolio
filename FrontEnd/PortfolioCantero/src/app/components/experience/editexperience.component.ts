import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { ExperienceService } from 'src/app/service/experience.service';

@Component({
  selector: 'app-editexperience',
  templateUrl: './editexperience.component.html',
  styleUrls: ['./editexperience.component.css']
})
export class EditexperienceComponent implements OnInit {

  expLab: Experience = null!; 

  constructor(private sExperience: ExperienceService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperience.detail(id).subscribe(data =>{
      this.expLab = data;      
    }, err => {
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperience.update(id, this.expLab).subscribe(data =>{
      this.router.navigate(['']);      
    }, err => {
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    } )
  }

}
