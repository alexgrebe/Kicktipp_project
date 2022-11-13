import { TestBed } from '@angular/core/testing';

import { NutzerguardService } from './nutzerguard.service';

describe('NutzerguardService', () => {
  let service: NutzerguardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NutzerguardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
