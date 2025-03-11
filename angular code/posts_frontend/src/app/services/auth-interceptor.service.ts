import { HttpEvent, HttpEventType, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable, tap } from "rxjs";

export class AuthInterceptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('Auth Interceptor is called');
    const modifiedReq = req.clone(
      {headers: req.headers.append('auth', 'abc123')});
    return next.handle(modifiedReq)
      .pipe(tap((event) => {
        if(event.type === HttpEventType.Response) {
          console.log('Response:', event.body.toString);
        }
      }))
  }

}
