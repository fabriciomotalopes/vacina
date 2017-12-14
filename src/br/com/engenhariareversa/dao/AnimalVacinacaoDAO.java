package br.com.engenhariareversa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.engenhariareversa.domain.AnimalVacinacao;
import br.com.engenhariareversa.util.HibernateUtil;

public class AnimalVacinacaoDAO {
	
	public void salvar(AnimalVacinacao objeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.save(objeto);
			transaction.commit();

		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<AnimalVacinacao> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<AnimalVacinacao> objetos = null;

		try {

			Query query = session.getNamedQuery("AnimalVacinacao.listar");
			objetos = query.list();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return objetos;
	}

	public AnimalVacinacao buscarPorId(Long idObjeto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		AnimalVacinacao objeto = null;

		try {

			Query query = session.getNamedQuery("AnimalVacinacao.buscarPorId");
			query.setLong("idAnimalVacinacao", idObjeto);
			objeto = (AnimalVacinacao) query.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return objeto;
	}

	public void excluir(AnimalVacinacao objeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.delete(objeto);
			transaction.commit();

		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(AnimalVacinacao objeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.update(objeto);
			transaction.commit();

		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}
}
