package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Accounts;
import in.ineuron.util.HibernateUtil;

public class DeleteRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {

			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Accounts accounts = new Accounts();
			accounts.setId(1);

			session.delete(accounts);
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
