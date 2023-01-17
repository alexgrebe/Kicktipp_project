import { TestBed } from '@angular/core/testing';

import { WettenligaService } from './wettenliga.service';

describe('WettenligaService', () => {
  let service: WettenligaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WettenligaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
