package com.module.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.module.basic.model.Client;
import com.module.basic.repository.ClientRepository;

@Controller
public class UserController {
	@Autowired
	ClientRepository ClientRepository;

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@ModelAttribute Client user) {
		ClientRepository.save(user);
		return "redirect:/";
	}

	@Autowired
	HttpSession session;

	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	@PostMapping("/signin")
	public String signinPost(@ModelAttribute Client user) {
		Client dbUser = ClientRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
		if (dbUser != null) {
			session.setAttribute("user_info", dbUser);
		}
		return "redirect:/";
	}
	@GetMapping("/signout")
	public String signout() {
	session.invalidate();
	return "redirect:/";
	}
}