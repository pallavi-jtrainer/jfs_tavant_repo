import { TestBed } from '@angular/core/testing';

import { PostsserviceService } from './postsservice.service';

describe('PostsserviceService', () => {
  let service: PostsserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostsserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
