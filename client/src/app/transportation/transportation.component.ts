import { Component, OnInit } from '@angular/core';
import { TransportationService } from '../services/transportation.service'
import { User } from '../models';
import { first } from 'rxjs/operators';

@Component({templateUrl: 'transportation.component.html'})
export class TransportationComponent implements OnInit {

    private transportationFootprint
    private currentUser: User

    constructor(
        private transportationService: TransportationService) { }

    ngOnInit() {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.transportationService.getTransportationFootprint(this.currentUser)
            .pipe(first())
            .subscribe(
                data => {
                    this.transportationFootprint = data
                },
                error => {
                    this.transportationFootprint = "5,000"
                });
        console.log(this.transportationService.getTransportationFootprint(this.currentUser))
    }
}