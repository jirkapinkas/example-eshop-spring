package cz.jiripinkas.example.eshop.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.eshop.domain.Basket;
import cz.jiripinkas.example.eshop.entity.OrderedItem;
import cz.jiripinkas.example.eshop.entity.UserOrder;

@Service
@Transactional
public class BasketService {

	@Autowired
	private UserOrderService userOrderService;

	@Autowired
	private OrderedItemService orderedItemService;

	public void save(Basket basket, UserOrder userOrder) {
		userOrder.setOrderDate(new Date());
		userOrder = userOrderService.save(userOrder);
		Collection<OrderedItem> items = basket.getItems();
		for (OrderedItem orderedItem : items) {
			orderedItem.setUserOrder(userOrder);
			orderedItemService.save(orderedItem);
		}
		basket.clear();
	}

}
