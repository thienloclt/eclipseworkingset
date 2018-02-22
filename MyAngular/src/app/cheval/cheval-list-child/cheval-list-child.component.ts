import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Cheval} from '../cheval.model';
import {ChevalService} from '../../service/cheval.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../framework/globals';

@Component({
  selector: 'app-child',
  templateUrl: './cheval-list-child.component.html',
  styleUrls: ['./cheval-list-child.component.css']
})
export class ChevalListChildComponent implements OnInit {
  @Input() cheval: Cheval;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  constructor(public globals: Globals, private route: ActivatedRoute, private chevalService: ChevalService, private router: Router) {
  }

  ngOnInit() {
  }

  deleteCheval(): void {
    this.chevalService.delete(this.cheval.id).subscribe( value => {
      this.eventemitter.emit('Object deleted');
      this.router.navigateByUrl('/cheval');
    });
  }
}
