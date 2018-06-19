export interface QuestionItem {
    id: number;
    question: string;
    answer: string;
    type: string;
}

export class ShortAnswer implements QuestionItem {
    id: number;
    question: string;
    answer: string;
    type: "ShortAnswer";
}

export class Dropdown implements QuestionItem {
    id: number;
    question: string;
    answer: string;
    options: string[];
    type: "Dropdown";
}