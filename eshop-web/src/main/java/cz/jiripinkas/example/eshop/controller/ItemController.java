package cz.jiripinkas.example.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import cz.jiripinkas.example.eshop.exception.ItemNotFoundException;
import cz.jiripinkas.example.eshop.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping
	public String showAll(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "items";
	}

	@RequestMapping(params = "id")
	public String showOne(Model model, @RequestParam int id) {
		model.addAttribute("item", itemService.findOne(id));
		return "item";
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleINFException(ItemNotFoundException ex) {
	}
}
