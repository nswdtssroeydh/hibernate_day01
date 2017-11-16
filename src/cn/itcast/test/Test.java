package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.itcast.bean.User;

public class Test {

	public static void main(String[] args) {

		//1加载hibernate核心配置文件，会到src下面去找hibernate.cfg.xml文件
		Configuration configuration = new Configuration();
		configuration.configure();
		//2创建sessionFactory对象，读取核心配置文件内容，根据hbm映射关系把表创建出来
		SessionFactory factory = configuration.buildSessionFactory();
		//3创建session
		Session session = factory.openSession();
		//4开启事务
		Transaction transaction = session.beginTransaction();
		
		//5具体操作:添加
		User user = new User();
		user.setUsername("白痴");
		user.setPassword("250");
		user.setAddress("日本");
		session.save(user);
		
		//6提交事务
		transaction.commit();
		
		//7关闭资源
		session.close();
		factory.close();
	}

}
