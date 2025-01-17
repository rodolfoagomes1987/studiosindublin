package dao;

import java.util.List;

import model.Customer;
import model.User;

public class CustomerDao extends Dao {

	public Customer byId(int id) {
		em = EntityManagerUtil.getEntityManager();
		Customer c = new Customer();
		try {
			c = em.createNamedQuery("Customer.findById", Customer.class).setParameter("id", id).getSingleResult();

		} catch (Exception e) {

		} finally {
			em.close();
		}
		return c;
	}

	public void remove(Customer u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public Customer update(Customer u) {

		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		u = em.merge(u);
		em.flush();
		em.getTransaction().commit();
		em.getEntityManagerFactory().getCache().evictAll();
		em.close();
		em = null;
		return u;

	}

	public void persist(Customer u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public List<Customer> list() {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("findAll", Customer.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<Customer> listByFinishDate() {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("Customer.findByFinishDate", Customer.class).getResultList();
		} finally {
			em.close();
		}

	}

	public List<Customer> listByDay() {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("Customer.findByDay", Customer.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<Customer> listByAgent() {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("Customer.findByAgent", Customer.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<Customer> listByInchargedAgent() {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("Customer.findByInchargedAgent", Customer.class).getResultList();
		} finally {
			em.close();
		}
	}

	public List<Customer> listByInchargedAgentByUser(User user) {
		em = EntityManagerUtil.getEntityManager();
		try {
			return em.createNamedQuery("Customer.findByInchargedAgentByUser", Customer.class)
					.setParameter("id", user.getId()).getResultList();
		} finally {
			em.close();
		}
	}

}
