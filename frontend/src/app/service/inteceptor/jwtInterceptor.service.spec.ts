import { TestBed } from '@angular/core/testing';

import { JwtInteceptorService } from './jwtInteceptor.service';

describe('JwtInteceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JwtInteceptorService = TestBed.get(JwtInteceptorService);
    expect(service).toBeTruthy();
  });
});
