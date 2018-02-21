import { Component, OnInit } from '@angular/core';
import {Cheval} from '../cheval/cheval.model';
import {ChevalService} from '../cheval.service';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  tab = [
    { 'id': 1,
      'nom': 'nom1',
      'remarque': 'remarque1'
    },
    { 'id': '2',
      'nom': 'nom2',
      'remarque': 'remarque2'
    },
    { 'id': '3',
      'nom': 'nom3',
      'remarque': 'remarque3',
      'centreequestres': []
    }
  ];
  tab1 = [
    { 'id': 1,
      'nom': 'nom1',
      'remarque': 'remarque1',
      'centreequestres': [
        {
          'id': 1,
          'nom': 'centreequestre1'
        },
        {
          'id': 3,
          'nom': 'centreequestre3'
        }
      ]
    },
    { 'id': '2',
      'nom': 'nom2',
      'remarque': 'remarque2',
      'centreequestres': [
        {
          'id': 2,
          'nom': 'centreequestre2'
        },
        {
          'id': 3,
          'nom': 'centreequestre3'
        }
      ]
    },
    { 'id': '3',
      'nom': 'nom3',
      'remarque': 'remarque3',
      'centreequestres': []
    }
  ];
  chevals: Array<Cheval> = [];

  constructor(private chevalService: ChevalService) {}

  ngOnInit() {
    this.chevalService.list().subscribe(chevalapi => this.chevals = chevalapi);
  }

  editCheval(){

  }
}
