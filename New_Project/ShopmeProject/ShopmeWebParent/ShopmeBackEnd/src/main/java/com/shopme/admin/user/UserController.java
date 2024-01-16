package com.shopme.admin.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.common.entity.Role;

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
		List<Role>listRoles=userService.listAll();
		Users user=new Users();
		user.setEnabled(true);
		model.addAttribute("user",user);
		model.addAttribute("listRoles",listRoles);
		return "user_form";
	}
	@PostMapping("/user/save") 
	public String saveUser(Users user ,RedirectAttributes redirectAttributes) {
	System.out.print(user);
	userService.saveUser(user);
	redirectAttributes.addFlashAttribute("message","The user has been saved successfully");
		return "redirect:/users";
	}

}
