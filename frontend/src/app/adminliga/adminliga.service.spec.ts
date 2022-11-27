import {TestBed} from '@angular/core/testing';

import {AdminligaService} from './adminliga.service';

describe('AdminligaService', () => {
  let service: AdminligaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminligaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
