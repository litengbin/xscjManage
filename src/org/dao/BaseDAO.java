package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @ClassName: BaseDAO
 * @Description: 基类
 * @author litengbin
 * @date 2017年6月11日
 * 
 */
public class BaseDAO {
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @Title: getSessionFactory
	 * @Description: sessionFactory的getter方法
	 * @param @return 参数
	 * @return SessionFactory 返回类型
	 * @throws
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 * @Title: setSessionFactory
	 * @Description: sessionFactory的setter方法
	 * @param @param sessionFactory 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @Title: getSession
	 * @Description: 获得session会话对象
	 * @param @return 参数
	 * @return Session 返回类型
	 * @throws
	 */
	public Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
}
