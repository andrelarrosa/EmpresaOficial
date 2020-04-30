package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Engenheiro;
import fabrica.Fabrica;

public class DAOEngenheiro {

	private EntityManager em;
	
	public Engenheiro salvar(Engenheiro engenheiro) {
		em = Fabrica.get().createEntityManager();
		EntityTransaction a = em.getTransaction();
		
		try {
			a.begin();
			em.persist(engenheiro);
			a.commit();
		}
		
		catch (Exception e) {
			a.rollback();
			e.printStackTrace();
		}
		
		finally {
			em.close();
		}
		
		return engenheiro;
	}
}
