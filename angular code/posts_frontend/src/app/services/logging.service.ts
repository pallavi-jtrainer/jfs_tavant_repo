import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {
  http: HttpClient = inject(HttpClient);

  // constructor(private httpClient: HttpClient) { }

  logError(data: {statusCode: number, errorMessage: string, errorDate: Date}) {
    this.http.post('https://angularhttpclient-f1d30-default-rtdb.firebaseio.com/log.json', data).subscribe();
  }

  fetchError() {
    return this.http.get('https://angularhttpclient-f1d30-default-rtdb.firebaseio.com/log.json')
    .subscribe({
      next: (data) => {
        console.log(data);
      }
    })
  }
}
