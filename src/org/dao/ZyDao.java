package org.dao;

import java.util.List;

import org.model.Zyb;

/**
 * 
 * @ClassName: ZyDao
 * @Description: 专业Dao接口
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface ZyDao {
	/**
	 * 
	 * @Title: getOneZy
	 * @Description: 学生信息查询
	 * @param @param zyId
	 * @param @return 参数
	 * @return Zyb 返回类型
	 * @throws
	 */
	public Zyb getOneZy(Integer zyId);// 根据专业ID查找专业信息

	/**
	 * 
	 * @Title: getAll
	 * @Description: 修改某学生信息
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List getAll();// 查找所有专业信息

}
