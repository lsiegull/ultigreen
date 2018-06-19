import { Component, OnInit } from '@angular/core';
import { QuestionItem, ShortAnswer, Dropdown } from '../questionItem';

@Component({
  selector: 'app-food-questionnaire',
  templateUrl: './food-questionnaire.component.html',
  styleUrls: ['./food-questionnaire.component.css']
})
export class FoodQuestionnaireComponent implements OnInit {
  title: string = "Food";
  foodQuestions: QuestionItem[] = [
    <ShortAnswer> {id: 1, question: "How many servings of lamb do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 2, question: "How many servings of beef do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 3, question: "How many servings of pork do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 4, question: "How many servings of turkey do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 5, question: "How many servings of chicken do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 6, question: "How many servings of tuna do you consume in 1 day? A serving of meat is 3 oz which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 7, question: "How many servings of eggs do you consume in 1 day? A serving of eggs is 1 egg.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 8, question: "How many servings of potato do you consume in 1 day? A serving of potato is approximately 1 medium potato.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 9, question: "How many servings of rice do you consume in 1 day? A serving of rice is 1/2 cup which is approximately the size of the front of your clenched fist.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 10, question: "How many servings of nuts do you consume in 1 day? A serving of nuts is 1/2 oz which is approximately how much can fit in half of your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 11, question: "How many servings of beans/tofu do you consume in 1 day? A serving of beans/ tofu is 1/4 cup which is approximately how much can fit in your palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 12, question: "How many servings of vegetables do you consume in 1 day? A serving of vegetables is 1 cup which is approximately how much can fit in a clenched palm.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 13, question: "How many servings of milk do you consume in 1 day? A serving of milk is 1 cup.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 14, question: "How many servings of fruit do you consume in 1 day? A serving of fruit is approximately 1 medium whole fruit.", answer: "3", type: "ShortAnswer"},
    <ShortAnswer> {id: 15, question: "How many servings of cheese do you consume in 1 day? A serving of cheese is 1.5 oz which is approximately how much can fit in half your palm.", answer: "3", type: "ShortAnswer"}  
  ];

  constructor() { }

  ngOnInit() {
  }

}
