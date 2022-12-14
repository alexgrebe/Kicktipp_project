import { TestBed } from '@angular/core/testing';

import { TipprundebeitretenService } from './tipprundebeitreten.service';

describe('TipprundebeitretenService', () => {
  let service: TipprundebeitretenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipprundebeitretenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
