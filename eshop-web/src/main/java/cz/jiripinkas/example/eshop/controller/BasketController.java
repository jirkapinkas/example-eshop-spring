package cz.jiripinkas.example.eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.jiripinkas.example.eshop.domain.Basket;
import cz.jiripinkas.example.eshop.service.ItemService;

@Controller
@RequestMapping("/basket")
@SessionAttributes("basket")
public class BasketController {

	@Autowired
	private ItemService itemService;

	@ModelAttribute("basket")
	public Basket construct() {
		return new Basket();
	}

	@RequestMapping
	public String show(Model model, HttpSession session) {
		return "basket";
	}

	@RequestMapping("/add")
	public String add(@RequestParam int id, @RequestParam int quantity,
			@ModelAttribute Basket basket) {
		basket.add(itemService.findOne(id), quantity);
		return "redirect:/items.html";
	}

	@RequestMapping("/remove")
	public String remove(@RequestParam int id, @ModelAttribute Basket basket) {
		basket.remove(id);
		return "redirect:/basket.html";
	}

}
