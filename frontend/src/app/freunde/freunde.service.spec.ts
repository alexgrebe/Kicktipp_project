import { TestBed } from '@angular/core/testing';

import { FreundeService } from './freunde.service';

describe('FreundeService', () => {
  let service: FreundeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FreundeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
