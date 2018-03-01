package org.service.imp;

import java.util.List;

import org.dao.CjDao;
import org.model.Cjb;
import org.service.CjService;

/**
 * 
 * @ClassName: CjServiceManage
 * @Description: CjService的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class CjServiceManage implements CjService {
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

	@Override
	public Cjb getXsCj(String xh, String kch) {// 根据学好和课程号查询学生成绩
		// TODO Auto-generated method stub
		return cjDao.getXsCj(xh, kch);
	}

	@Override
	public void saveorupdateCj(Cjb cj) {// 录入学生成绩
		// TODO Auto-generated method stub
		cjDao.saveorupdateCj(cj);
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// 分页显示所有学生成绩
		// TODO Auto-generated method stub
		return cjDao.findAllCj(pageNow, pageSize);
	}

	@Override
	public int findCjSize() {// 查询一共多少条成绩记录
		// TODO Auto-generated method stub
		return cjDao.findCjSize();
	}

	@Override
	public List getXsCjList(String xh) {// 获取某学生的成绩列表
		// TODO Auto-generated method stub
		return cjDao.getXsCjList(xh);
	}

	@Override
	public void deleteCj(String xh, String kch) {// 根据学好和课程号删除学生成绩
		// TODO Auto-generated method stub
		cjDao.deleteCj(xh, kch);
	}

	@Override
	public void deleteOneXsCj(String xh) {// 删除某学生的成绩
		// TODO Auto-generated method stub
		cjDao.deleteOneXsCj(xh);
	}

	@Override
	public void updateKcList(String kch, int xf) {
		// TODO Auto-generated method stub
		cjDao.updateKcList(kch, xf);
	}

	@Override
	public List getXsCjList1(String kch) {
		// TODO Auto-generated method stub
		return cjDao.getXsCjList1(kch);
	}

	@Override
	public void deleteKcList(String kch) {
		// TODO Auto-generated method stub
		cjDao.deleteKcList(kch);
	}
}
