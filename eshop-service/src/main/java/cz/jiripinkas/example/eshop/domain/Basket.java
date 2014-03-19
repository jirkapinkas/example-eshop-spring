package cz.jiripinkas.example.eshop.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import cz.jiripinkas.example.eshop.entity.Item;
import cz.jiripinkas.example.eshop.entity.OrderedItem;

public class Basket implements Serializable {

	private static final long serialVersionUID = 1L;

	private HashMap<Integer, OrderedItem> items = new HashMap<Integer, OrderedItem>();

	public void add(Item item, int quantity) {
		int itemId = item.getItemId();
		if (items.containsKey(itemId)) {
			OrderedItem orderedItem = items.get(itemId);
			orderedItem.setQuantity(orderedItem.getQuantity() + quantity);
		} else {
			OrderedItem orderedItem = new OrderedItem();
			orderedItem.setItem(item);
			orderedItem.setQuantity(quantity);
			items.put(item.getItemId(), orderedItem);
		}
	}

	public Collection<OrderedItem> getItems() {
		return items.values();
	}

	public void remove(int itemId) {
		items.remove(itemId);
	}

	public void clear() {
		items.clear();
	}
}
