package cz.jiripinkas.example.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.jiripinkas.example.eshop.service.UserOrderService;

@Controller
@RequestMapping("/user-orders")
public class UserOrdersController {

	@Autowired
	private UserOrderService userOrderService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("userOrders", userOrderService.findAll());
		return "user-orders";
	}
}
