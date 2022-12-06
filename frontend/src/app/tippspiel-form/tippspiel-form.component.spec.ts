import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TippspielFormComponent } from './tippspiel-form.component';

describe('TippspielFormComponent', () => {
  let component: TippspielFormComponent;
  let fixture: ComponentFixture<TippspielFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TippspielFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TippspielFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
