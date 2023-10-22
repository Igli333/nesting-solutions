import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DormStructureComponent } from './dorm-structure.component';

describe('DormStructureComponent', () => {
  let component: DormStructureComponent;
  let fixture: ComponentFixture<DormStructureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DormStructureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DormStructureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
