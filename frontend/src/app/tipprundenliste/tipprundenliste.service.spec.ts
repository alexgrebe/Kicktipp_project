import { TestBed } from '@angular/core/testing';

import { TipprundenlisteService } from './tipprundenliste.service';

describe('TipprundenlisteService', () => {
  let service: TipprundenlisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipprundenlisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
