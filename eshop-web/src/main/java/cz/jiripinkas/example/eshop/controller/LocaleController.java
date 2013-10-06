package cz.jiripinkas.example.eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/locale")
public class LocaleController {

	@RequestMapping
	public String changeLocale(HttpSession session,
			@RequestHeader String referer, @RequestParam String locale) {
		session.setAttribute("currentLocale", locale);
		return "redirect:" + referer;
	}
}
