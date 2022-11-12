import { TestBed } from '@angular/core/testing';

import { SpieleService } from './spiele.service';

describe('SpieleService', () => {
  let service: SpieleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpieleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
