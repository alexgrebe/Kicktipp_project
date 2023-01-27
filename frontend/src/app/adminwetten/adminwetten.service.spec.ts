import { TestBed } from '@angular/core/testing';

import { AdminwettenService } from './adminwetten.service';

describe('AdminwettenService', () => {
  let service: AdminwettenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminwettenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
