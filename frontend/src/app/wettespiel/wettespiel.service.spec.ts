import { TestBed } from '@angular/core/testing';

import { WettespielService } from './wettespiel.service';

describe('WettespielService', () => {
  let service: WettespielService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WettespielService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
