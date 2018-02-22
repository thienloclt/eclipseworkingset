import {Component, OnInit} from '@angular/core';
import {Cheval} from '../cheval.model';
import {ChevalService} from '../../service/cheval.service';

@Component({
  selector: 'app-chevallist',
  templateUrl: './cheval-list.component.html',
  styleUrls: ['./cheval-list.component.css']
})
export class ChevalListComponent implements OnInit {
  chevals: Array<Cheval> = [];
  constructor(private chevalService: ChevalService) {}

  ngOnInit() {
    this.getList();
  }
  getFromChild(event) {
    this.getList();
  }
  getList() {
    this.chevalService.list().subscribe(chevalsFromREST => this.chevals = chevalsFromREST);
  }
}
