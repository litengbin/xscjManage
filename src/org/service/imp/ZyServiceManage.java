package org.service.imp;

import java.util.List;

import org.dao.ZyDao;
import org.model.Zyb;
import org.service.ZyService;

/**
 * 
 * @ClassName: ZyServiceManage
 * @Description: ZyService的实现类
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public class ZyServiceManage implements ZyService {
	private ZyDao zyDao;

	/**
	 * 
	 * @Title: getZyDao
	 * @Description: zyDao的getter方法
	 * @param @return 参数
	 * @return ZyDao 返回类型
	 * @throws
	 */
	public ZyDao getZyDao() {
		return zyDao;
	}

	/**
	 * 
	 * @Title: setZyDao
	 * @Description: zyDao的setter方法
	 * @param @param zyDao 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setZyDao(ZyDao zyDao) {
		this.zyDao = zyDao;
	}

	@Override
	public Zyb getOneZy(Integer zyId) {// 根据专业ID查找专业信息
		// TODO Auto-generated method stub
		return zyDao.getOneZy(zyId);
	}

	@Override
	public List getAll() {// 查找所有专业信息
		// TODO Auto-generated method stub
		return zyDao.getAll();
	}

}
