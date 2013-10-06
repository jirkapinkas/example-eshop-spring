package cz.jiripinkas.example.eshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.jiripinkas.example.eshop.domain.Basket;
import cz.jiripinkas.example.eshop.entity.UserOrder;
import cz.jiripinkas.example.eshop.service.BasketService;

@Controller
@RequestMapping("/order")
@SessionAttributes("basket")
public class OrderController {

	@Autowired
	private BasketService basketService;

	@ModelAttribute("userOrder")
	public UserOrder userOrder() {
		UserOrder userOrder = new UserOrder();
		userOrder.setCity("Prague");
		return userOrder;
	}

	@RequestMapping
	public String show() {
		return "order";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid UserOrder userOrder,
			BindingResult bindingResult, @ModelAttribute Basket basket) {
		if (bindingResult.hasErrors()) {
			return "order";
		}
		basketService.save(basket, userOrder);
		return "redirect:/order.html?thanks";
	}

	@RequestMapping(params = { "thanks" })
	public String showThanks() {
		return "order-thanks";
	}

}
