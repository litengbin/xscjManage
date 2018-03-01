package org.service.imp;

import java.util.List;

import org.dao.CjDao;
import org.dao.XsDao;
import org.model.Xsb;
import org.service.XsService;

/**
 * 
 * @ClassName: XsServiceManage
 * @Description: XsService的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class XsServiceManage implements XsService {
	private XsDao xsDao;
	private CjDao cjDao;

	/**
	 * 
	 * @Title: getCjDao
	 * @Description: cjDao的getter方法
	 * @param @return 参数
	 * @return CjDao 返回类型
	 * @throws
	 */
	public CjDao getCjDao() {
		return cjDao;
	}

	/**
	 * 
	 * @Title: setCjDao
	 * @Description: cjDao的setter方法
	 * @param @param cjDao 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}

	/**
	 * 
	 * @Title: getXsDao
	 * @Description: xsDao的getter方法
	 * @param @return 参数
	 * @return XsDao 返回类型
	 * @throws
	 */
	public XsDao getXsDao() {
		return xsDao;
	}

	/**
	 * 
	 * @Title: setXsDao
	 * @Description: xsDao的setter方法
	 * @param @param xsDao 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setXsDao(XsDao xsDao) {
		this.xsDao = xsDao;
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// 显示所有学生信息
		// TODO Auto-generated method stub
		return xsDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findXsSize() {// 查询一共多少条学生记录
		// TODO Auto-generated method stub
		return xsDao.findXsSize();
	}

	@Override
	public Xsb find(String xh) {// 根据学号查询某学生信息
		// TODO Auto-generated method stub
		return xsDao.find(xh);
	}

	@Override
	public void delete(String xh) {// 根据学号删除学生
		// TODO Auto-generated method stub
		xsDao.delete(xh);
		// cjDao.deleteOneXsCj(xh);
	}

	@Override
	public void update(Xsb xs) {// 修改学生信息
		// TODO Auto-generated method stub
		xsDao.update(xs);
	}

	@Override
	public void save(Xsb xs) {// 插入学生信息
		// TODO Auto-generated method stub
		xsDao.save(xs);
	}

	@Override
	public void updateXf(int xf, List list) {
		// TODO Auto-generated method stub
		xsDao.updateXf(xf, list);
	}

}
