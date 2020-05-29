package modify.service.impl;

import java.util.List;

import modify.db.MyHibernateSessionFactory;
import modify.entity.User;
import modify.service.UserDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//�û�ҵ���߼��ӿڵ�ʵ����
public class UserDAOImpl implements UserDAO {

	
	//�����û�id��ѯ�û�����
	public User queryUserByUid(int userId) {
	
		Transaction tx = null;
		User u = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			u = (User)session.get(User.class, userId);
			
			tx.commit();
			return u;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return u;
		}
		finally {
			if(tx != null) {
				tx = null;
			}
		}
	}

	//�޸��û�����
	public boolean updateUser(User u) {
		
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx != null) {
				tx = null;
			}
		}
	}

}
