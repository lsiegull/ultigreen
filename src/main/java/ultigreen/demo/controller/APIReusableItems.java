package ultigreen.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ultigreen.demo.ReusablesService;
import ultigreen.demo.domain.AppUser;
import ultigreen.demo.domain.ReusableQuestion;

@RestController
@RequestMapping(path="/reusables")
public class APIReusableItems {
	
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ReusablesService reusablesService;
    
	public APIReusableItems() {
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path= "/")
	public ResponseEntity addQuestions(@RequestBody ReusableQuestion question) {
		if (question != null) {
			return reusablesService.addQuestions(question);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path= "/updateQuestion")
	public ResponseEntity updateQuestions(@RequestBody ReusableQuestion question) {
		if (question != null) {
			return reusablesService.makeUpdatedData(question);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(path= "/getUpdates/{username}")
	public ResponseEntity getUserData(@PathVariable("username") String username) {
		if (username != null) {
			return reusablesService.getUpdatedData(username);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(path="/makeUpdates/{username}")
	public ResponseEntity updateUserData(@PathVariable("username") String username, @RequestBody ReusableQuestion question) {
		return null;
	}
	
	
	
}
