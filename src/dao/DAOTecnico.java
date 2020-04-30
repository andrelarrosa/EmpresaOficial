package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Tecnico;
import fabrica.Fabrica;

public class DAOTecnico {

	private EntityManager em;

	public Tecnico salvar(Tecnico tecnico) {

		em = Fabrica.get().createEntityManager();
		EntityTransaction a = em.getTransaction();

		try {
			a.begin();
			em.persist(tecnico);
			a.commit();
		}

		catch (Exception e) {
			a.rollback();
			e.printStackTrace();
		}

		finally {
			em.close();
		}

		return tecnico;
	}
	
	public List<Tecnico> buscar(String consulta){
		em = Fabrica.get().createEntityManager();
		Query query = null;
		try {
			query = em.createQuery("from Tecnico where nome like :nome");
			query.setParameter("nome","%" + consulta + "%" );
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return query.getResultList();
	}
}
