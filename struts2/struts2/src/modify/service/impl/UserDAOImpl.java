package modify.service.impl;

import java.util.List;

import modify.db.MyHibernateSessionFactory;
import modify.entity.User;
import modify.service.UserDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//用户业务逻辑接口的实现类
public class UserDAOImpl implements UserDAO {

	
	//根据用户id查询用户资料
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

	//修改用户资料
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
