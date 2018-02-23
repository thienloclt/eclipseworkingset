import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Globals} from '../../framework/globals';
import {CentreEquestreService} from '../../service/centreequestre.service';
import {ChevalService} from '../../service/cheval.service';
import {CentreEquestre} from '../../model/centreequestre.model';

@Component({
  selector: 'app-cheval-add',
  templateUrl: './cheval-add.component.html',
  styleUrls: ['./cheval-add.component.css']
})
export class ChevalAddComponent implements OnInit {
  id: number;
  monform: FormGroup;
  formsubmitted: boolean = false;
  centreequestres: Array<CentreEquestre> = [];
  authorsSelected: CentreEquestre[] = [];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private chevalService: ChevalService, private centreequestreService: CentreEquestreService) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
    this.centreequestreService.list().subscribe(centreequestresFromREST => {
      this.centreequestres = centreequestresFromREST;
    });
    this.monform = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'remarque': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'centreEquestre': [this.authorsSelected]
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
    console.log('centreEquestre' + this.monform.controls['centreEquestre'].value);
    console.log(this.monform.value)
    this.formsubmitted = true;
    if(this.monform.valid){
      if (this.id) {
        this.chevalService.update(this.monform.value).subscribe(val => {
          this.router.navigateByUrl('/cheval');
        });
      }
      else {
        this.chevalService.add(this.monform.value).subscribe(val => {
          this.router.navigateByUrl('/cheval');
        });
      }
    }
  }
}
