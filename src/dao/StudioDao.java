package dao;

import java.util.List;

import model.Studio;

public class StudioDao extends Dao {

	public Studio byId(int id) {
		em = EntityManagerUtil.getEntityManager();
		try {
			Studio studio = em.find(Studio.class, id);

			return studio;
		} finally {
			em.close();
		}
	}

	public void remove(Studio u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public void update(Studio u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.flush();
		em.getTransaction().commit();
		em.clear();
		em.close();
		em = null;

	}

	public void persist(Studio u) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = null;

	}

	public List<Studio> listByAddress(int addressId) {
		em = EntityManagerUtil.getEntityManager();
		try {
			List<Studio> list = em.createNamedQuery("Studio.findAllByAddress", Studio.class)
					.setParameter("idAdress", addressId).getResultList();

			return list;
		} finally {
			em.close();
		}
	}

}
