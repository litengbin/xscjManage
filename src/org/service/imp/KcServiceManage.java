package org.service.imp;

import java.util.List;

import org.dao.KcDao;
import org.model.Kcb;
import org.service.KcService;

/**
 * 
 * @ClassName: KcServiceManage
 * @Description: KcService的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class KcServiceManage implements KcService {
	private KcDao kcDao;

	/**
	 * 
	 * @Title: getKcDao
	 * @Description: kcDao的getter方法
	 * @param @return 参数
	 * @return KcDao 返回类型
	 * @throws
	 */
	public KcDao getKcDao() {
		return kcDao;
	}

	/**
	 * 
	 * @Title: setKcDao
	 * @Description: kcDao的setter方法
	 * @param @param kcDao 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setKcDao(KcDao kcDao) {
		this.kcDao = kcDao;
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// 查询所有课程信息
		// TODO Auto-generated method stub
		return kcDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findKcSize() {// 查询一共多少条课程记录
		// TODO Auto-generated method stub
		return kcDao.findKcSize();
	}

	@Override
	public Kcb find(String kch) {// 根据课程号查找课程信息
		// TODO Auto-generated method stub
		return kcDao.find(kch);
	}

	@Override
	public void delete(String kch) {
		// TODO Auto-generated method stub
		kcDao.delete(kch);
	}

	@Override
	public void update(Kcb kc) {
		// TODO Auto-generated method stub
		kcDao.update(kc);
	}

	@Override
	public void save(Kcb kc) {
		// TODO Auto-generated method stub
		kcDao.save(kc);
	}

}
