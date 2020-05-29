package modify.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;	//会话工厂类
	
	//构造方法私有化，保证单例模式
	private MyHibernateSessionFactory() {
		
	}
	
	//公有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			//创建配置对象（读取配置文档）
			Configuration config = new Configuration().configure();
			//创建会话工厂对象
			sessionFactory = config.buildSessionFactory();
			//返回会话工厂实例
			return sessionFactory;
		}
		else {
			return sessionFactory;
		}
	}
}
