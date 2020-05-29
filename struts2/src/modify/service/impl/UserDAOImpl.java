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

//	//用户登录
//	public boolean userLogin(User u) {
//		//创建事务对象
//		Transaction tx = null;
//		String hql = "";
//		try {
//			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx = session.beginTransaction();
//			hql = "from User where username=? and password=?";
//			Query query = session.createQuery(hql);
//			query.setParameter(0, u.getUserName());
//			query.setParameter(1, u.getPassword());
//			List list = query.list();
//			tx.commit();	//提交事务一定要在return之前，捕获异常之后再返回的话就是false了
//			
//			//判断是否查到用户
//			if(list.size() > 0) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		finally {
//			if(tx != null) {
//				tx = null;
//			}
//		}
//	}
	
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
