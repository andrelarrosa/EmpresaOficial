package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import entidade.Secretario;
import fabrica.Fabrica;

public class DAOSecretario<T> {

	private EntityManager em;


	public Secretario salvar(Secretario secretario) {
		em = Fabrica.get().createEntityManager();
		EntityTransaction a = em.getTransaction();

		try {
			a.begin();
			em.persist(secretario);
			a.commit();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}

		catch (Exception e) {
			a.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return secretario;
	}

/*	public Secretario alterar(Secretario secretario) {
		em = Fabrica.get().createEntityManager();
		EntityTransaction a = em.getTransaction();
		Secretario secretarioBanco = buscar(secretario.getId());
		Query query = null;
		try {
			a.begin();
			secretarioBanco.setNome(secretario.getNome());
			secretarioBanco.setCpf(secretario.getCpf());
			secretarioBanco.setLinguaEstrangeira(secretario.getLinguaEstrangeira());
			secretarioBanco.setLinguaMaterna(secretario.getLinguaMaterna());
			em.merge(secretarioBanco);
			a.commit();
		} catch (Exception e) {
			a.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return secretarioBanco;
	}*/

	public T alterar(T objeto) {
		em = Fabrica.get().createEntityManager();
		EntityTransaction a = em.getTransaction();
		try {
			a.begin();
			em.merge(objeto);
			a.commit();
		} catch (Exception e) {
			a.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return objeto;
	}
	public boolean excluir(long id) {
		em = Fabrica.get().createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		try {
			transacao.begin();
			Secretario objeto = em.find(Secretario.class, id);
			if (objeto != null) {				
				em.remove(objeto);
				transacao.commit();
				return true;
			}
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();

		} finally {
			em.close();
		}
		return false;
	}

	public Secretario buscar(long id) {
		em = Fabrica.get().createEntityManager();
		return em.find(Secretario.class, id);
	}

	public List<Secretario> buscar() {
		em = Fabrica.get().createEntityManager();
		Query query = null;
		try {
			query = em.createQuery("from " + Secretario.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	public List<Secretario> buscar(String consulta) {
		em = Fabrica.get().createEntityManager();
		Query query = null;
		try {
			query = em.createQuery("from Secretario where nome like :nome");
			query.setParameter("nome", "%" + consulta + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return query.getResultList();
	}
}


