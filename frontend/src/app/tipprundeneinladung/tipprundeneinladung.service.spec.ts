import { TestBed } from '@angular/core/testing';

import { TipprundeneinladungService } from './tipprundeneinladung.service';

describe('TipprundeneinladungService', () => {
  let service: TipprundeneinladungService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipprundeneinladungService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
