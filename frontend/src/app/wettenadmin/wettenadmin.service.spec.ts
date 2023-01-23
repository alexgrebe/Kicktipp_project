import { TestBed } from '@angular/core/testing';

import { WettenadminService } from './wettenadmin.service';

describe('WettenadminService', () => {
  let service: WettenadminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WettenadminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
