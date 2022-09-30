import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-editeducation',
  templateUrl: './editeducation.component.html',
  styleUrls: ['./editeducation.component.css']
})
export class EditeducationComponent implements OnInit {

  education: Education = null!;

  constructor(private sEducation: EducationService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sEducation.detail(id).subscribe(data => {
      this.education = data;
    }, err =>{
      alert("Error al modificar la educacion.");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sEducation.update(id, this.education).subscribe(data =>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar la educacion");
      this.router.navigate(['']);
    })
  }

}
