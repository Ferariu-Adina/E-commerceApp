package ro.adina.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/signup")
    public String showSignUpForm(Model model) {
		
		model.addAttribute("user", new Account());
        return "add-user";
    }
	@PostMapping("/addUser")
	public String addProduct(@RequestParam("name") String name,@RequestParam("email") String email, Model model) {
		
		Account newUser = new Account(name, email);
		userRepo.save(newUser);
		
		//greetings.add(newGreeting);
		
		model.addAttribute("users", userRepo.findAll());
		
		return "user";	
	}

}
