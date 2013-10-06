package cz.java.skoleni.eshop.service;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cz.jiripinkas.example.eshop.entity.Item;
import cz.jiripinkas.example.eshop.entity.OrderedItem;
import cz.jiripinkas.example.eshop.entity.UserOrder;
import cz.jiripinkas.example.eshop.service.ItemService;
import cz.jiripinkas.example.eshop.service.OrderedItemService;
import cz.jiripinkas.example.eshop.service.UserOrderService;

public class EShopServiceTest {

	private static ItemService itemService;
	private static OrderedItemService orderedItemService;
	private static UserOrderService userOrderService;

	@BeforeClass
	public static void init() {
		itemService = new ItemService();
		orderedItemService = new OrderedItemService();
		userOrderService = new UserOrderService();

//		itemService.setEntityManager(Emf.getEntityManagerFactory(true)
//				.createEntityManager());
//		orderedItemService.setEntityManager(Emf.getEntityManagerFactory(true)
//				.createEntityManager());
//		userOrderService.setEntityManager(Emf.getEntityManagerFactory(true)
//				.createEntityManager());
	}

	@Ignore
	@Test
	public void testCreateDb() {
		{
			Item item = new Item();
			item.setName("Java in 21 days");
			item.setDescription("EBook");
			item.setPrice(500);
			itemService.save(item);
		}
		{
			Item item = new Item();
			item.setName("Java cup");
			item.setDescription("Coffee cup");
			item.setPrice(100);
			itemService.save(item);
		}
		{
			Item item = new Item();
			item.setName("Java t-shirt");
			item.setDescription("T-shirts for all Java programmers");
			item.setPrice(500);
			itemService.save(item);
		}
		{
			Item item = new Item();
			item.setName("Professional Java consulting");
			item.setDescription("per manhour");
			item.setPrice(1000);
			itemService.save(item);
		}
		{
			Item item = new Item();
			item.setName("Professional Java training");
			item.setDescription("per manday");
			item.setPrice(13000);
			itemService.save(item);
		}
		{
			UserOrder userOrder = new UserOrder();
			userOrder.setName("Michal Knihomol");
			userOrder.setCity("Praha");
			userOrder.setOrderDate(new Date());
			userOrder.setStreet("Knihovni 1");
			userOrder.setZip("110 00");
			userOrderService.save(userOrder);

			OrderedItem orderedItem = new OrderedItem();
			orderedItem.setItem(itemService.findOne(1));
			orderedItem.setUserOrder(userOrder);
			orderedItem.setQuantity(5);
			orderedItemService.save(orderedItem);
		}
	}

}
