import { TestBed } from '@angular/core/testing';

import { TippService } from './tipp.service';

describe('TippService', () => {
  let service: TippService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TippService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
