import {Component, Input, OnInit} from '@angular/core';
import {ChevalService} from '../cheval.service';
import {Cheval} from '../cheval/cheval.model';
import {ParentComponent} from '../parent/parent.component';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  @Input() chevalIDinput: number;
  cheval = new Cheval();

  routes: Routes = [{ path: 'heroes', component: ParentComponent }];
1
  constructor(private chevalService: ChevalService) { }

  ngOnInit() {
      this.chevalService.get(this.chevalIDinput).subscribe(chevalapi => this.cheval = chevalapi);
  }

  addCheval(): void {
    this.chevalService.add(this.cheval).subscribe();
  }
}
