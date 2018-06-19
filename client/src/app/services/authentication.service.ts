import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }

    login(username: string, password: string) {
        return this.http.get<any>('http://localhost:8080/users/login', {
            params: {
                username: username,
                password: password 
            }
        }).pipe(map(user => {
            if (user) {
                localStorage.setItem('currentUser', JSON.stringify(user.username));
            }
            return user;
        }));
    } 

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}