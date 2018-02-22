import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChevalListChildComponent } from './cheval-list-child.component';

describe('ChevalListChildComponent', () => {
  let component: ChevalListChildComponent;
  let fixture: ComponentFixture<ChevalListChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChevalListChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChevalListChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});