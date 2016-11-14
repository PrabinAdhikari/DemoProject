package edu.prabin.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.prabin.demo.domain.User;
import edu.prabin.demo.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("user") User user) {

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user, Model model) {
		userService.save(user);

		return "home";
	}

	@RequestMapping(value = "/display")
	public String displayUserList(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "display";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "edit";
	}

	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, Model model) {
		System.out.println(":::::::::::::::::::::::::" + user.getId());
		System.out.println(":::::::::::::::::::::::::" + user.getEmail());
		userService.update(user);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "display";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		userService.delete(id);
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "display";
	}

}
