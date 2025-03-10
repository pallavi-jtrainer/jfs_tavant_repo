import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Posts } from '../models/posts';

@Injectable({
  providedIn: 'root'
})
export class PostsService {
  private baseUrl = "http://localhost:9001/api";

  constructor(private http: HttpClient) { }

  getAllPost(): Observable<Posts[]> {
    return this.http.get<Posts[]>(`${this.baseUrl}/posts`)
    .pipe(catchError(this.errorHandler));
  }

  getPostDetails(id: number): Observable<Posts>{
    return this.http.get<Posts>(`${this.baseUrl}/post/${id}`)
    .pipe(catchError(this.errorHandler));
  }

  createPost(post: Posts): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/posts`, post)
    .pipe(catchError(this.errorHandler));
  }

  getPostDetailsByTitle(title: string): Observable<Posts>{
    return this.http.get<Posts>(`${this.baseUrl}/post/title/${title}`)
    .pipe(catchError(this.errorHandler));;
  }

  getPostsForUser(id: number): Observable<Posts[]> {
    return this.http.get<Posts[]>(`${this.baseUrl}/posts/user/${id}`)
    .pipe(catchError(this.errorHandler));
  }

  updatePostTitle(id: number, post: Posts):Observable<any>{
    return this.http.patch<any>(
      `${this.baseUrl}/post/update/${id}/${post.title}`, post)
      .pipe(catchError(this.errorHandler));
  }

  updatePostBody(id: number, post: Posts): Observable<any>{
    return this.http.patch<any>(
      `${this.baseUrl}/post/body/${id}/${post.body}`, post)
      .pipe(catchError(this.errorHandler));
  }

  private errorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(() =>
      console.log('Unable to process your request; please try again later.'));
  }
}
