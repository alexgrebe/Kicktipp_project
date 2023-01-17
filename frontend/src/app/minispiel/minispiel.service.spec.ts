import { TestBed } from '@angular/core/testing';

import { MinispielService } from './minispiel.service';

describe('MinispielService', () => {
  let service: MinispielService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MinispielService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
