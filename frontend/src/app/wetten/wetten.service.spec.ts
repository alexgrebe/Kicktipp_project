import { TestBed } from '@angular/core/testing';

import { WettenService } from './wetten.service';

describe('WettenService', () => {
  let service: WettenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WettenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
