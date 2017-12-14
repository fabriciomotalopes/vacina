package br.com.engenhariareversa.main;

import br.com.engenhariareversa.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		

	}

}
