import {Component, OnInit} from '@angular/core';
import {Cheval} from '../../model/cheval.model';
import {ChevalService} from '../../cheval.service';

@Component({
  selector: 'app-chevallist',
  templateUrl: './chevallist.component.html',
  styleUrls: ['./chevallist.component.css']
})
export class ChevalListComponent implements OnInit{
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
