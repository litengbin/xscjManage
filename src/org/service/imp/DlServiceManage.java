package org.service.imp;

import java.util.List;

import org.dao.DlDao;
import org.model.Dlb;
import org.service.DlService;

/**
 * 
 * @ClassName: DlServiceImp
 * @Description: DlService接口的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class DlServiceManage implements DlService {
	private DlDao dlDao;

	/**
	 * 
	 * @Title: getDlDao
	 * @Description: dlDao的getter方法
	 * @param @return 参数
	 * @return DlDao 返回类型
	 * @throws
	 */
	public DlDao getDlDao() {
		return dlDao;
	}

	/**
	 * 
	 * @Title: setDlDao
	 * @Description: dlDao的setter方法
	 * @param @param dlDao 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setDlDao(DlDao dlDao) {
		this.dlDao = dlDao;
	}

	@Override
	public Dlb find(String xh, String kl) {// 根据学号和口令查找
		// TODO Auto-generated method stub
		return dlDao.find(xh, kl);
	}

	@Override
	public List findAll(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return dlDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findDlSize() {
		// TODO Auto-generated method stub
		return dlDao.findDlSize();
	}

	@Override
	public void delete(String xh) {
		// TODO Auto-generated method stub
		dlDao.delete(xh);
	}

	@Override
	public void update(Dlb dl) {
		// TODO Auto-generated method stub
		dlDao.update(dl);
	}

	@Override
	public void save(Dlb dl) {
		// TODO Auto-generated method stub
		dlDao.save(dl);
	}

	@Override
	public Dlb find1(String xh) {
		// TODO Auto-generated method stub
		return dlDao.find1(xh);
	}

}
