import {Component, Input, OnInit} from '@angular/core';
import {ChevalService} from '../../service/cheval.service';
import {ActivatedRoute, Router, Routes} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Globals} from '../../framework/globals';

@Component({
  selector: 'app-add',
  templateUrl: './cheval-add.component.html',
  styleUrls: ['./cheval-add.component.css']
})
export class ChevalAddComponent implements OnInit {
  id: number;
  monform: FormGroup;
  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private chevalService: ChevalService, private router: Router) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
    this.monform = this.fb.group({
      'id': [''],
      'nom': [''],
      'remarque': ['']
    });
  }

  ngOnInit() {
    if (this.id) {
      this.chevalService.get(this.id).subscribe(chevalFromREST => {
        this.monform.controls['id'].setValue(chevalFromREST.id);
        this.monform.controls['nom'].setValue(chevalFromREST.nom);
        this.monform.controls['remarque'].setValue(chevalFromREST.remarque);
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


