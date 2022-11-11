import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigaComponent } from './liga.component';

describe('LigaComponent', () => {
  let component: LigaComponent;
  let fixture: ComponentFixture<LigaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LigaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
