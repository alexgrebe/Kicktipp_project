import { TestBed } from '@angular/core/testing';

import { LigaService } from './liga.service';

describe('LigaService', () => {
  let service: LigaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LigaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
