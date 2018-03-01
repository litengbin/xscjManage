package org.service;

import java.util.List;

import org.model.Kcb;

/**
 * 
 * @ClassName: KcService
 * @Description: KcService接口
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface KcService {
	/**
	 * 
	 * @Title: findAll
	 * @Description: 查询所有课程信息
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findKcSize
	 * @Description: 查询一共多少条课程记录
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int findKcSize();

	/**
	 * 
	 * @Title: find
	 * @Description: 根据课程号查找课程信息
	 * @param @param kch
	 * @param @return 参数
	 * @return Kcb 返回类型
	 * @throws
	 */
	public Kcb find(String kch);

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除课程信息
	 * @param @param kch 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(String kch);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改课程信息
	 * @param @param kc 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void update(Kcb kc);
	
	/**
	 * 
	 * @Title: save
	 * @Description: 增加课程信息
	 * @param @param kc 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void save(Kcb kc);
}
