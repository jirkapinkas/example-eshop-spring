package cz.jiripinkas.example.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.eshop.entity.Item;
import cz.jiripinkas.example.eshop.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public Item findOne(int itemId) {
		return itemRepository.findOne(itemId);
	}

	public Iterable<Item> findAll() {
		return itemRepository.findAll();
	}

	public void remove(int itemId) {
		itemRepository.remove(itemId);
	}

	public void removeAll() {
		itemRepository.removeAll();
	}
}
