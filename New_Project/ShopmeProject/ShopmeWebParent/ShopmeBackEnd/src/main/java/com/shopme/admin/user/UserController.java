package com.shopme.admin.user;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopme.common.entity.Users;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		  List<Users>listUsers=userService.lisrAll();
		  model.addAttribute("listUsers",listUsers);
		return "users";
	}
	@GetMapping("/users/new")
	public String newUser(Model model) {
		Users user=new Users();
		model.addAttribute("user",user);
		return "user_form";
	}
	@PostMapping("/user/save") 
	public String saveUser(Users user) {
	System.out.print(user);
		return "redirect:/users";
	}

}
