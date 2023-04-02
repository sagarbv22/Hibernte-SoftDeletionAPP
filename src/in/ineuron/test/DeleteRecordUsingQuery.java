package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Accounts;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordUsingQuery {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			//@Where doesn't work in HQL,NativeQuery, Criteria
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery("DELETE FROM in.ineuron.model.Accounts WHERE id=:id");
			query.setParameter("id", 4);
			int update = query.executeUpdate();
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Changed the status to closed");
			} else {
				transaction.rollback();
				System.out.println("Failed");
			}
		}
	}

}
