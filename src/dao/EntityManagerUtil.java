package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("StudiosDublin");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
