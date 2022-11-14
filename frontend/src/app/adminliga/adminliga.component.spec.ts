import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminligaComponent } from './adminliga.component';

describe('AdminligaComponent', () => {
  let component: AdminligaComponent;
  let fixture: ComponentFixture<AdminligaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminligaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminligaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
