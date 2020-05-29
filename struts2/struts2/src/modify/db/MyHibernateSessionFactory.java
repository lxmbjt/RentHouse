package modify.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;	//�Ự������
	
	//���췽��˽�л�����֤����ģʽ
	private MyHibernateSessionFactory() {
		
	}
	
	//���еľ�̬��������ûỰ��������
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			//�������ö��󣨶�ȡ�����ĵ���
			Configuration config = new Configuration().configure();
			//�����Ự��������
			sessionFactory = config.buildSessionFactory();
			//���ػỰ����ʵ��
			return sessionFactory;
		}
		else {
			return sessionFactory;
		}
	}
}
