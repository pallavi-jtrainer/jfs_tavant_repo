import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Posts } from '../models/posts';

@Injectable({
  providedIn: 'root'
})
export class PostsService {
  private baseUrl = "http://localhost:9001/api";

  constructor(private http: HttpClient) { }

  getAllPost(): Observable<Posts[]> {
    return this.http.get<Posts[]>(`${this.baseUrl}/posts`);
  }

  getPostDetails(id: number): Observable<Posts>{
    return this.http.get<Posts>(`${this.baseUrl}/post/${id}`);
  }

  createPost(post: Posts): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/posts`, post);
  }
}
