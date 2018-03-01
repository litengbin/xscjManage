package org.dao.imp;

import java.util.Iterator;
import java.util.List;

import org.dao.BaseDAO;
import org.dao.XsDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Cjb;
import org.model.Xsb;

/**
 * 
 * @ClassName: XsDaoImp
 * @Description: 学生Dao的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class XsDaoImp extends BaseDAO implements XsDao {

	@Override
	public List findAll(int pageNow, int pageSize) {// 显示所有学生信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Xsb order by xh");
			int firstResult = (pageNow - 1) * pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			list = query.list();
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int findXsSize() {// 查询一共有多少条学生记录
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		int xsSize = 0;
		try {
			session = getSession();
			ts = session.beginTransaction();
			xsSize = session.createQuery("from Xsb").list().size();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return xsSize;
	}

	@Override
	public Xsb find(String xh) {// 根据学号查询某个学生信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Xsb xs = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Xsb where xh = ?");
			query.setParameter(0, xh);
			query.setMaxResults(1);
			xs = (Xsb) query.uniqueResult();
			ts.commit();
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return xs;
	}

	@Override
	public void delete(String xh) {// 根据学号删除学生
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Xsb xs = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			xs = find(xh);
			session.delete(xs);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Xsb xs) {// 修改学生信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(xs);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void save(Xsb xs) {// 插入学生
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(xs);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateXf(int xf, List list) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Query query = session.createQuery("update Xsb set zxf = zxf + ? where xh = ?");
				query.setParameter(0, xf);
				Cjb cj =  (Cjb)it.next();
				query.setParameter(1,cj.getId().getXsb().getXh());
				query.executeUpdate();
			}
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
