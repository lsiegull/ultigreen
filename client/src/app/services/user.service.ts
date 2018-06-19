import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestOptions } from '@angular/http';

import { User } from '../models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    // getAll() {
    //     return this.http.get<User[]>('/api/users');
    // }

    // getById(id: number) {
    //     return this.http.get('/api/users/' + id);
    // }

    create(user: User) {
        return this.http.post('http://localhost:8080/users/signup', null, {
            params: {
                username: user.username,
                password: user.password
            }
        });
    }

    // update(user: User) {
    //     return this.http.put('/api/users/' + user.id, user);
    // }

    // delete(id: number) {
    //     return this.http.delete('/api/users/' + id);
    // }
}