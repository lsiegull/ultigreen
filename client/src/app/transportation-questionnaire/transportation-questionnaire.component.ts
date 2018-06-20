import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';
import { User, TransportationInfo } from '../models';
import { UserService, TransportationService } from '../services';

@Component({
  selector: 'app-transportation-questionnaire',
  templateUrl: './transportation-questionnaire.component.html',
  styleUrls: ['./transportation-questionnaire.component.css']
})
export class TransportationQuestionnaireComponent implements OnInit {
  title: string = "Transportation";
  transportationQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How far away in miles do you live from work?", answer: "12", type:"ShortAnswer"},
    <ShortAnswer> {id: 2, question: "What is the mileage of your car?", answer: "40", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many people do you carpool with?", answer: "5", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many times/ week do you carpool to and from work?", answer: "10", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many times/ week do you bus to and from work?", answer: "", type: "ShortAnswer"},
    <ShortAnswer> {id: 6, question: "How many times/ week do you bike or walk to and from work?", answer: "", type: "ShortAnswer"}
  ];
  selectedQ: QuestionItem;
  prevPage = "reusable-dishware-questionnaire";
  nextPage = "questionnaire-results";
  currentUser: User;
  
  constructor(private userService: UserService, private transportationService: TransportationService) { 
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    transportationService.getLatestEntry(this.currentUser).subscribe(a => {
      this.transportationQuestions[0].answer = a.distanceFromWork === null ? "0" : String(a.distanceFromWork);
      this.transportationQuestions[1].answer = a.mileageOfCar === null ? "0" : String(a.mileageOfCar);
      this.transportationQuestions[2].answer = a.numCarpools === null ? "1" : String(a.numCarpools);
      this.transportationQuestions[3].answer = a.numTimesDriveToFromWorkWeekly === null ? "0" : String(a.numTimesDriveToFromWorkWeekly);
      this.transportationQuestions[4].answer = a.numTimesBusToFromWorkWeekly === null ? "0" : String(a.numTimesBusToFromWorkWeekly);
      this.transportationQuestions[5].answer = a.numTimesBikeWalkToFromWorkWeekly === null ? "0" : String(a.numTimesBikeWalkToFromWorkWeekly);
    });
  }

  ngOnInit() {
    //alert(this.currentUser + "hi" + this.currentTransportationInfo.username);
  }

}
