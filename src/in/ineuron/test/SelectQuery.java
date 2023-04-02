package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Accounts;
import in.ineuron.util.HibernateUtil;

public class SelectQuery {

	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();
			Query<Accounts> query = session.createQuery("FROM in.ineuron.model.Accounts");

			List<Accounts> list = query.getResultList();

			list.forEach(System.out::println);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
