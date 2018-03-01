package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.CjDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Cjb;
import org.model.CjbId;
import org.model.Kcb;
import org.model.Xsb;

/**
 * 
 * @ClassName: CjDaoImp
 * @Description: 成绩Dao的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class CjDaoImp extends BaseDAO implements CjDao {

	@Override
	public Cjb getXsCj(String xh, String kch) {// 根据学号和课程号查询学生成绩
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Cjb cj = null;
		Xsb xsb = new Xsb();
		xsb.setXh(xh);
		Kcb kcb = new Kcb();
		kcb.setKch(kch);
		try {
			CjbId cjbId = new CjbId();
			cjbId.setXsb(xsb);
			cjbId.setKcb(kcb);
			session = getSession();
			ts = session.beginTransaction();
			cj = (Cjb) session.get(Cjb.class, cjbId);
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
		return cj;
	}

	@Override
	public void saveorupdateCj(Cjb cj) {// 录入学生成绩
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.saveOrUpdate(cj);
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
	public List findAllCj(int pageNow, int pageSize) {// 分页显示所有学生成绩
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session
					.createQuery("select c.id.xsb.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kcb.kch from Xsb a,Kcb b,Cjb c where"
							+ " a.xh = c.id.xsb.xh and b.kch = c.id.kcb.kch");
			query.setFirstResult((pageNow - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
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
		return list;
	}

	@Override
	public int findCjSize() {// 查询一共多少条成绩记录
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		int cjSize = 0;
		try {
			session = getSession();
			ts = session.beginTransaction();
			List list = session.createQuery("from Cjb").list();
			cjSize = list.size();
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
		return cjSize;
	}

	@Override
	public List getXsCjList(String xh) {// 获取某学生的成绩列表
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session
					.createQuery("select c.id.xsb.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kcb.kch from Xsb a,"
							+ "Kcb b,Cjb c where c.id.xsb.xh = ? and a.xh = c.id.xsb.xh and b.kch = c.id.kcb.kch");
			query.setParameter(0, xh);
			list = query.list();
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
		return list;
	}

	@Override
	public void deleteCj(String xh, String kch) {// 根据学号和课程号删除学生成绩
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(getXsCj(xh, kch));
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
	public void deleteOneXsCj(String xh) {// 删除某学生的成绩
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(getXsCjList(xh));
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
	public void updateKcList(String kch, int xf) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session
					.createQuery("update Cjb set xf = ? where kch = ?");
			query.setParameter(0, xf);
			query.setParameter(1, kch);
			query.executeUpdate();
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
	public List getXsCjList1(String kch) {// 获取某课程的学生列表
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Cjb where kch = ?");
			query.setParameter(0, kch);
			list = query.list();
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
		return list;
	}

	@Override
	public void deleteKcList(String kch) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session
					.createQuery("delete from Cjb where kch = ?");
			query.setParameter(0, kch);
			query.executeUpdate();
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
