package ultigreen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ultigreen.demo.domain.AppUser;
import ultigreen.demo.domain.UserRepository;

@RestController
@RequestMapping(path="/users")
public class APIUserAuthentication {

	@Autowired
	private UserRepository userRepository;
	
    public APIUserAuthentication() {
    	
    }
    
    @PostMapping(path="/signup")
    public @ResponseBody String signUp(@RequestParam String name, @RequestParam String password) {
    	AppUser u = new AppUser();
    	u.setUsername(name);
    	u.setPassword(password);
    	userRepository.save(u);
    	return "Saved";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
    	Iterable<AppUser> uList = userRepository.findAll();
    	for (AppUser user : uList) {
    		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
    			return new ResponseEntity(user, HttpStatus.OK);
    		}
    	}
    	return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(path="/testAll")
    public @ResponseBody Iterable<AppUser> getAllUsers() {
    	return userRepository.findAll();
    }
    
}
