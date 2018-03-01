package org.service;

import java.util.List;

import org.model.Dlb;

/**
 * 
 * @ClassName: DlService
 * @Description: 系统登录功能Service接口
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface DlService {
	/**
	 * 
	 * @Title: find
	 * @Description: 根据学号和口令查找
	 * @param @param xh
	 * @param @param kl
	 * @param @return 参数
	 * @return Dlb 返回类型
	 * @throws
	 */
	public Dlb find(String xh, String kl);

	/**
	 * 
	 * @Title: findAll
	 * @Description: 登陆信息查询
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findXsSize
	 * @Description: 查询登陆信息记录总数
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int findDlSize();

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除登陆信息
	 * @param @param xh 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改登陆信息
	 * @param @param dl 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void update(Dlb dl);

	/**
	 * 
	 * @Title: save
	 * @Description: 增加登录信息
	 * @param @param dl 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void save(Dlb dl);

	/**
	 * 
	 * @Title: find1
	 * @Description: 查看学生的详细信息
	 * @param @param xh
	 * @param @return 参数
	 * @return Dlb 返回类型
	 * @throws
	 */
	public Dlb find1(String xh);

}
