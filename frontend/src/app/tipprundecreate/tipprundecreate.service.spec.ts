import { TestBed } from '@angular/core/testing';

import { TipprundecreateService } from './tipprundecreate.service';

describe('TipprundecreateService', () => {
  let service: TipprundecreateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipprundecreateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
