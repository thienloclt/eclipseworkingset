import {Component, Input, OnInit} from '@angular/core';
import {ChevalService} from '../../cheval.service';
import {Cheval} from '../../model/cheval.model';
import {ActivatedRoute, Router, Routes} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-add',
  templateUrl: './cheval-add.component.html',
  styleUrls: ['./cheval-add.component.css']
})
export class ChevalAddComponent implements OnInit {
  cheval = new Cheval();
  id: number;
  monform: FormGroup;
  constructor(private fb: FormBuilder, private route: ActivatedRoute, private chevalService: ChevalService, private router: Router) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
    this.monform = this.fb.group({
      'nom': [''],
      'remarque': ['']
    });
  }

  ngOnInit() {
    if (this.id){
      this.chevalService.get(this.id).subscribe(chevalFromREST => {
        this.cheval = chevalFromREST;
        this.monform.controls['nom'].setValue(this.cheval.nom);
        this.monform.controls['remarque'].setValue(this.cheval.remarque);
      });
    }
  }

  onSubmit() {
    console.log(this.monform.value);
    if (this.id) {
      console.log('update' + this.id);
      this.chevalService.update(this.monform.value).subscribe(val => {
        this.router.navigateByUrl('/cheval');
      });
    }
    else {
      console.log('add');
      this.chevalService.add(this.monform.value).subscribe(val => {
        this.router.navigateByUrl('/cheval');
      });
    }
  }
}


