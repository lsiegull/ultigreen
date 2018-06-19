package ultigreen.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/reusables")
public class APIReusableItems {

	public APIReusableItems() {
		
	}
	
	@SuppressWarnings({ "rawtypes" })
	public ResponseEntity calculateRFootprint() {
		return new ResponseEntity(HttpStatus.OK);
	}
}
