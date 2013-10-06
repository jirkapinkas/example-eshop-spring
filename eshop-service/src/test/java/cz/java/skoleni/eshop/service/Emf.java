package cz.java.skoleni.eshop.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Emf {

	private static final String PERSISTENCE_UNIT_NAME = "EShopService";
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		return getEntityManagerFactory(false);
	}

	public static EntityManagerFactory getEntityManagerFactory(boolean create) {
		if (entityManagerFactory == null) {
			if (create) {
				Map<String, String> configOverrides = new HashMap<String, String>();
				configOverrides.put("hibernate.hbm2ddl.auto", "create");
				entityManagerFactory = Persistence.createEntityManagerFactory(
						PERSISTENCE_UNIT_NAME, configOverrides);
			} else {
				entityManagerFactory = Persistence
						.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			}
		}
		return entityManagerFactory;
	}
}
