import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopLabelComponent } from './top-label.component';

describe('TopLabelComponent', () => {
  let component: TopLabelComponent;
  let fixture: ComponentFixture<TopLabelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopLabelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopLabelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
