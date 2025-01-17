package dao;

import java.util.List;

import model.Scheduling;

public class SchedulingDao extends Dao {

	public Scheduling byId(int id) {
		em = EntityManagerUtil.getEntityManager();
		return em.find(Scheduling.class, id);
	}

	public void update(Scheduling u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void delete(int id) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Scheduling.class, id));
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void persist(Scheduling u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public List<Scheduling> list() {
		em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("Scheduling.findAll", Scheduling.class).getResultList();

	}
	
	public List<Scheduling> byTodayDate() {
		em = EntityManagerUtil.getEntityManager();
		return em.createNamedQuery("Scheduling.byTodayDate", Scheduling.class).getResultList();

	}

}
