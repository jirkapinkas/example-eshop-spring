package cz.jiripinkas.example.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.eshop.entity.UserOrder;
import cz.jiripinkas.example.eshop.repository.UserOrderRepository;

@Service
@Transactional
public class UserOrderService {

	@Autowired
	private UserOrderRepository userOrderRepository;

	public UserOrder save(UserOrder userOrder) {
		return userOrderRepository.save(userOrder);
	}

	public UserOrder findOne(int userOrderId) {
		return userOrderRepository.findOne(userOrderId);
	}

	public Iterable<UserOrder> findAll() {
		return userOrderRepository.findAll();
	}

}
