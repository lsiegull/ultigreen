import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestOptions } from '@angular/http';
import { map } from 'rxjs/operators';

import { User } from '../models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    create(user: User) {
        return this.http.post('http://localhost:8080/users/signup', null, {
            params: {
                username: user.username,
                password: user.password
            }
        }).pipe(map(user => {
            return user
        }));
    }
}