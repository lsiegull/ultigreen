import { Component, OnInit, Input } from '@angular/core';
import {QuestionItem} from '../questionItem';

@Component({
  selector: 'app-questionnaire-page',
  templateUrl: './questionnaire-page.component.html',
  styleUrls: ['./questionnaire-page.component.css']
})
export class QuestionnairePageComponent implements OnInit {
  @Input() title: string;
  @Input() questionItems: QuestionItem[];
  @Input() prevPage: string;
  @Input() nextPage: string;

  selectedQ: QuestionItem;

  constructor() { }

  ngOnInit() {
  }

  onSelect(selectedQ: QuestionItem): void {
    this.selectedQ = selectedQ;
  }

  ngOnClick(isPrevious: boolean): void {
    if (isPrevious) { //previous button
      alert("Previous screen");
    }else { //next button
      alert("Next screen");

    }
  }

}
