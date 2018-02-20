import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  get text1(): string {
    return this._text1;
  }

  set text1(value: string) {
    this._text1 = value;
  }
  private _text1 = 'abc';

  constructor() {
  }

  ngOnInit() {
  }

  changeText(): void {
      this._text1 = prompt('Enter your text');
  }
}
