import { Component, OnInit } from '@angular/core';
import {Globals} from '../globals';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  changeThemes(): void {
    console.log('Theme: ' + this.globals.theme);
  }
}
