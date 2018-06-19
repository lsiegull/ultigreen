package ultigreen.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ultigreen.demo.domain.AppUser;
import ultigreen.demo.domain.ReusableAnswer;
import ultigreen.demo.domain.ReusableAnswerRepository;
import ultigreen.demo.domain.ReusableQuestion;

@RestController
@RequestMapping(path="/reusables")
public class APIReusableItems {

	private ReusableAnswerRepository repository;
	
	public APIReusableItems() {
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path="/total")
	public ResponseEntity calculateRFootprint(AppUser user) {
		int carbonTotal = 0;
		Iterable<ReusableAnswer> answers = repository.findAll();
		for (ReusableAnswer answer : answers ) {
			if (answer.getUser().getUsername().equals(user.getUsername())) {
				carbonTotal += answer.getCarbon();
			}
		}
		return new ResponseEntity(carbonTotal, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path= "/")
	public ResponseEntity addRQuestions(@RequestBody List<ReusableQuestion> questions, AppUser user) {
		for ( ReusableQuestion question: questions ) {
			ReusableAnswer rAnswer = new ReusableAnswer();
			rAnswer.setQuestion(question);
			rAnswer.setResponse(question.getResponse());
			rAnswer.setUser(user);
			rAnswer.setType();
			rAnswer.setCarbon();
			repository.save(rAnswer);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
