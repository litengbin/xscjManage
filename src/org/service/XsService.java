package org.service;

import java.util.List;

import org.model.Xsb;

/**
 * 
 * @ClassName: XsService
 * @Description: 学生信息管理功能Service
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface XsService {
	/**
	 * 
	 * @Title: findAll
	 * @Description: 显示所有学生信息
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
	 * @Description: 查询一共多少条学生记录
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int findXsSize();

	/**
	 * 
	 * @Title: find
	 * @Description: 查看某个学生的详细信息
	 * @param @param xh
	 * @param @return 参数
	 * @return Xsb 返回类型
	 * @throws
	 */
	public Xsb find(String xh);

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除某学生信息
	 * @param @param xh 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改某学生信息
	 * @param @param xs 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void update(Xsb xs);

	/**
	 * 
	 * @Title: save
	 * @Description: 学生信息录入
	 * @param @param xs 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void save(Xsb xs);

	/**
	 * 
	 * @Title: updateXf
	 * @Description: 更新总学分
	 * @param @param xf
	 * @param @param list 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void updateXf(int xf, List list);
}
