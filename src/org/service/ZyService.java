package org.service;

import java.util.List;

import org.model.Zyb;

/**
 * 
 * @ClassName: ZyService
 * @Description: 业务逻辑ZyService接口
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface ZyService {
	/**
	 * 
	 * @Title: getOneZy
	 * @Description: 根据专业Id查找专业信息
	 * @param @param zyId
	 * @param @return 参数
	 * @return Zyb 返回类型
	 * @throws
	 */
	public Zyb getOneZy(Integer zyId);

	/**
	 * 
	 * @Title: getAll
	 * @Description: 查找所有专业信息
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List getAll();
}
