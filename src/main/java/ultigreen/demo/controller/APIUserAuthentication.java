package ultigreen.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ultigreen.demo.domain.AppUser;
import ultigreen.demo.domain.UserRepository;

@RestController
@RequestMapping("/users")
public class APIUserAuthentication {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    public APIUserAuthentication(UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.userRepository = userRepository;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    	}
    
    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    @GetMapping("testing")
    public @ResponseBody String getStuff() {
    	return "stuff";
    }
}
