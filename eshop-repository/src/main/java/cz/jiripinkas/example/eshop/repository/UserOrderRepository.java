package cz.jiripinkas.example.eshop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cz.jiripinkas.example.eshop.entity.UserOrder;

@Repository
public class UserOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public UserOrder save(UserOrder userOrder) {
		if (userOrder.getUserOrderId() == 0) {
			entityManager.persist(userOrder);
			return entityManager.find(UserOrder.class,
					userOrder.getUserOrderId());
		} else {
			return entityManager.merge(userOrder);
		}
	}

	public UserOrder findOne(int userOrderId) {
		return entityManager.find(UserOrder.class, userOrderId);
	}

	public Iterable<UserOrder> findAll() {
		return entityManager
				.createQuery(
						"select distinct o from UserOrder o left join fetch o.orderedItems",
						UserOrder.class).getResultList();
	}

}
