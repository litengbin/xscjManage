package org.action;

import java.util.List;
import java.util.Map;

import org.model.Cjb;
import org.model.CjbId;
import org.model.Kcb;
import org.model.Xsb;
import org.service.CjService;
import org.service.KcService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: CjAction
 * @Description: 成绩Action类
 * @author litengbin
 * @date 2017年6月13日
 * 
 */
public class CjAction extends ActionSupport {
	private Cjb cj;
	private XsService xsService;
	private KcService kcService;
	private CjService cjService;
	private int pageNow = 1;
	private int pageSize = 8;

	@Override
	public String execute() throws Exception {// 获取已有的所有学生和课程名列表
		// TODO Auto-generated method stub
		List list1 = xsService.findAll(1, xsService.findXsSize());// 通过XsService接口获取已有学生名
		List list2 = kcService.findAll(1, kcService.findKcSize());// 通过KcService接口获取已有课程名
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list1", list1);// 把所有学生名列表存入请求中返回
		request.put("list2", list2);// 把所有课程名列表存入请求中返回
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addorupdateXscj
	 * @Description: 成绩录入
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addorupdateXscj() throws Exception {// 执行成绩录入操作
		Cjb cj1 = null;
		CjbId cjId1 = new CjbId();
		String xh = cj.getId().getXsb().getXh();
		String kch = cj.getId().getKcb().getKch();
		// 通过CjService业务逻辑接口中的getXsCj()方法判断成绩记录是否已存在
		if (cjService.getXsCj(xh, kch) == null) {
			cj1 = new Cjb();
			Xsb xsb = xsService.find(xh);
			Kcb kcb = kcService.find(kch);
			cjId1.setKcb(kcb);
			cjId1.setXsb(xsb);
			cj1.setId(cjId1);
		} else// 成绩记录已经存在
		{
			cj1 = cjService.getXsCj(xh, kch);
		}
		Kcb kc1 = kcService.find(kch);// 通过KcService接口获取相应的课程的学分值
		cj1.setCj(cj.getCj());
		if (cj.getCj() > 60 || cj.getCj() == 60) {// 判断成绩及格，才赋给学分
			cj1.setXf(kc1.getXf());
		} else {
			cj1.setXf(0);// 不及格的没有学分
		}
		cjService.saveorupdateCj(cj1);// 通过CjService业务逻辑接口保存或更新成绩
		// 更新xsb里的总学分
		List list = cjService.getXsCjList(xh);
		Xsb xs = xsService.find(xh);
		int zxf = 0;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			zxf += Integer.valueOf(obj[4].toString().trim());
		}
		xs.setZxf(zxf);
		xsService.update(xs);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: xscjInfo
	 * @Description: 显示所有学生成绩
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String xscjInfo() throws Exception {
		// 直接使用CjService业务逻辑接口中的findAllCj()方法
		List list = cjService.findAll(this.getPageNow(), this.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		Pager page = new Pager(this.getPageNow(), cjService.findCjSize());
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findXscj
	 * @Description: 获取学生成绩列表
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String findXscj() throws Exception {
		// 使用CjService业务逻辑接口中的getXsCjList()方法获取某学生的成绩列表
		List list = cjService.getXsCjList(cj.getId().getXsb().getXh());
		if (list.size() > 0) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 
	 * @Title: deleteOneXscj
	 * @Description: 删除学生成绩
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteOneXscj() throws Exception {
		String xh = cj.getId().getXsb().getXh();
		String kch = cj.getId().getKcb().getKch();
		cjService.deleteCj(xh, kch);// 通过CjService业务逻辑接口中的deleteCj()方法执行删除
		// 更新xsb里的总学分
		List list = cjService.getXsCjList(xh);
		Xsb xs = xsService.find(xh);
		int zxf = 0;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			zxf += Integer.valueOf(obj[4].toString().trim());
		}
		xs.setZxf(zxf);
		xsService.update(xs);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getCj
	 * @Description: cj的getter方法
	 * @param @return 参数
	 * @return Cjb 返回类型
	 * @throws
	 */
	public Cjb getCj() {
		return cj;
	}

	/**
	 * 
	 * @Title: setCj
	 * @Description: cj的setter方法
	 * @param @param cj 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setCj(Cjb cj) {
		this.cj = cj;
	}

	/**
	 * 
	 * @Title: getXsService
	 * @Description: XsService的getter方法
	 * @param @return 参数
	 * @return XsService 返回类型
	 * @throws
	 */
	public XsService getXsService() {
		return xsService;
	}

	/**
	 * 
	 * @Title: setXsService
	 * @Description: xsService的setter方法
	 * @param @param xsService 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	/**
	 * 
	 * @Title: getKcService
	 * @Description: KcService的getter方法
	 * @param @return 参数
	 * @return KcService 返回类型
	 * @throws
	 */
	public KcService getKcService() {
		return kcService;
	}

	/**
	 * 
	 * @Title: setKcService
	 * @Description: KcService的setter方法
	 * @param @param kcService 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setKcService(KcService kcService) {
		this.kcService = kcService;
	}

	/**
	 * 
	 * @Title: getCjService
	 * @Description: cjService的getter方法
	 * @param @return 参数
	 * @return CjService 返回类型
	 * @throws
	 */
	public CjService getCjService() {
		return cjService;
	}

	/**
	 * 
	 * @Title: setCjService
	 * @Description: cjService的setter方法
	 * @param @param cjService 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setCjService(CjService cjService) {
		this.cjService = cjService;
	}

	/**
	 * 
	 * @Title: getPageNow
	 * @Description: pageNow的getter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getPageNow() {
		return pageNow;
	}

	/**
	 * 
	 * @Title: setPageNow
	 * @Description: pageNow的setter方法
	 * @param @param pageNow 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: pageSize的getter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: pageSize的setter方法
	 * @param @param pageSize 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
