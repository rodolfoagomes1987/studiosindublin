package dao;

import java.util.List;

import model.Address;

public class AddressDao extends Dao {

	public Address byId(int id) {
		em = EntityManagerUtil.getEntityManager();
		try {
			Address address = em.find(Address.class, id);

			return address;
		} finally {
			em.close();
		}
	}

	public void update(Address u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void persist(Address u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public List<Address> list() {
		em = EntityManagerUtil.getEntityManager();
		try {
			List<Address> list = em.createNamedQuery("Address.findAll", Address.class).getResultList();
			return list;
		} finally {
			em.close();
		}

	}

}
