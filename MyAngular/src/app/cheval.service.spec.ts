import { TestBed, inject } from '@angular/core/testing';

import { ChevalService } from './cheval.service';

describe('ChevalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChevalService]
    });
  });

  it('should be created', inject([ChevalService], (service: ChevalService) => {
    expect(service).toBeTruthy();
  }));
});
