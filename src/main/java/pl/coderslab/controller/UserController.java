package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.entity.User;
import pl.coderslab.model.UserDTO;
import pl.coderslab.repository.UserRepository;


@Controller
@RequestMapping("/user")
@SessionAttributes({"loggedInUser"}) // kazdy atrybut o tej nazwy dodany do sesji 
public class UserController {
	// wstrzykujmey userrespository aby zapisywac w bazie
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user) {
		this.userRepo.save(user);
		return "redirect:/login";
	
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new UserDTO());
		return "login";
	}
	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute UserDTO user, Model model, BindingResult br) {
		
		User u =	this.userRepo.findOneByEmail(user.getEmail());
		if(u!= null && u.isPasswordCorrect(user.getPassword())) {
			model.addAttribute("loggedInUser",u);
			return "redirect:/user";
		}
		return "redirect:/login";
	
	}
	
	//BindingResult br co to jest i po co
}
