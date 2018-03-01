package org.dao;

import java.util.List;

import org.model.Xsb;

/**
 * 
 * @ClassName: XsDao
 * @Description: 学生信息管理功能Dao
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface XsDao {
	/**
	 * 
	 * @Title: findAll
	 * @Description: 学生信息查询
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
	 * @Description: 查询学生记录总数
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int findXsSize();

	/**
	 * 
	 * @Title: find
	 * @Description: 查看学生的详细信息
	 * @param @param xh
	 * @param @return 参数
	 * @return Xsb 返回类型
	 * @throws
	 */
	public Xsb find(String xh);

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除学生信息
	 * @param @param xh 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改学生信息
	 * @param @param xs 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void update(Xsb xs);

	/**
	 * 
	 * @Title: save
	 * @Description: 增加学生信息
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
