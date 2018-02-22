import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Cheval} from '../../model/cheval.model';
import {ChevalService} from '../../cheval.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-child',
  templateUrl: './chevallist-child.component.html',
  styleUrls: ['./chevallist-child.component.css']
})
export class ChevalListChildComponent implements OnInit {
  @Input() cheval: Cheval;
  @Output() eventemitter : EventEmitter<string> = new EventEmitter<string>();

  constructor(private route: ActivatedRoute, private chevalService: ChevalService, private router: Router) {
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
