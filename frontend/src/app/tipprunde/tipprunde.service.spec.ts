import { TestBed } from '@angular/core/testing';

import { TipprundeService } from './tipprunde.service';

describe('TipprundeService', () => {
  let service: TipprundeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipprundeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
