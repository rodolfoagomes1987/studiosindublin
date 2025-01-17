package dao;

import java.util.List;

import model.User;

public class UserDao extends Dao {

	public User byId(int id) {
		em = EntityManagerUtil.getEntityManager();
		return em.find(User.class, id);
	}

	public User byLoginAndPAssword(String login, String password) {
		em = EntityManagerUtil.getEntityManager();
		User u = null;
		try {
			u = em.createNamedQuery("User.findByLoginAndPassword", User.class).setParameter("login", login)
					.setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			System.out.println("User or Password invalid!!!");
		}
		return u;
	}

	public void remove(User u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void update(User u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void persist(User u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public List<User> list() {
		em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("User.findAll", User.class).getResultList();
	}

	public User byLogin(String login) {
		em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("User.findByLogin", User.class).setParameter("login", login).getSingleResult();
	}

}
