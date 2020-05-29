package modify.service.impl;

import java.util.List;

import modify.db.MyHibernateSessionFactory;
import modify.entity.House;
import modify.service.HouseDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//�û�ҵ���߼��ӿڵ�ʵ����
public class HouseDAOImpl implements HouseDAO {
	
	//����id��ѯ��������
	public House queryHouseByUid(int houseId) {
	
		Transaction tx = null;
		House u = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			u = (House)session.get(House.class, houseId);
			
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

	//�޸ķ�������
	public boolean updateHouse(House u) {
		
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
