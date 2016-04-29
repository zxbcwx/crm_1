package com.atguigu.crm.handler;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entity.User;
import com.atguigu.crm.service.UserService;

@RequestMapping("/user")
@Controller
public class UserHandler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username")String name,
					@RequestParam("password")String password,
					RedirectAttributes attr,
					HttpSession session,
					Locale locale){
		User user = userService.getUserByName(name, password);
		if(user == null){
			String message = messageSource.getMessage("error.user.login", null, locale);
			attr.addFlashAttribute("message",message);
			return "redirect:/index";
		}
		session.setAttribute("user", user);
		return "home/success";
	}

}
