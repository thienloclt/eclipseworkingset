import { Component, OnInit, Input } from '@angular/core';
import {Cheval} from '../cheval/cheval.model';
import {ChevalService} from '../cheval.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  @Input() cheval: Cheval;

  constructor(private chevalService: ChevalService) {
  }

  ngOnInit() {
  }
}
