package org.action;

import java.util.List;
import java.util.Map;

import org.model.Kcb;
import org.service.CjService;
import org.service.KcService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KcAction extends ActionSupport {
	private int pageNow = 1;
	private int pageSize = 8;
	private Kcb kc;
	private KcService kcService;
	private XsService xsService;
	private CjService cjService;

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

	/**
	 * 
	 * @Title: getKc
	 * @Description: kc的getter方法
	 * @param @return 参数
	 * @return Kcb 返回类型
	 * @throws
	 */
	public Kcb getKc() {
		return kc;
	}

	/**
	 * 
	 * @Title: setKc
	 * @Description: kc的setter方法
	 * @param @param kc 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setKc(Kcb kc) {
		this.kc = kc;
	}

	/**
	 * 
	 * @Title: getXsService
	 * @Description: xsService的getter方法
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
	 * @Description: kcService的getter方法
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
	 * @Description: kcService的setter方法
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

	@Override
	public String execute() throws Exception {// 显示所有学生信息
		// TODO Auto-generated method stub
		List list = kcService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), kcService.findKcSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findKc
	 * @Description: 用于从数据库中查找某个学生的详细信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String findKc() throws Exception {
		String kch = kc.getKch();
		Kcb k = kcService.find(kch);// 直接使用KchService业务逻辑接口中的find方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("kc", k);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: deleteKc
	 * @Description: 删除课程信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteKc() throws Exception {
		String kch = kc.getKch();
		this.setKc(kcService.find(kch));
		int xf = kc.getXf();
		List list = cjService.getXsCjList1(kch);
		kcService.delete(kch);// 直接使用kcService业务逻辑接口中的delete方法
		//修改学生的总学分
		cjService.deleteKcList(kc.getKch());
		xsService.updateXf(0 - xf, list);
		
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateKcView
	 * @Description: 显示课程修改页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateKcView() throws Exception {
		String kch = kc.getKch();
		Kcb kcInfo = kcService.find(kch);// 直接使用kcbService业务逻辑接口中的find()方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("kcInfo", kcInfo);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateKc
	 * @Description: 执行修改操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateKc() throws Exception {
		Kcb kc1 = kcService.find(kc.getKch());// 直接使用kcService业务逻辑接口的find()方法
		kc1.setKcm(kc.getKcm());
		kc1.setKxxq(kc.getKxxq());
		kc1.setXs(kc.getXs());
		int xf = kc1.getXf();
		kc1.setXf(kc.getXf());
		Map request = (Map) ActionContext.getContext().get("request");
		kcService.update(kc1);// 直接使用kcService业务逻辑接口中的update()方法
		if (xf != kc.getXf()) {
			cjService.updateKcList(kc.getKch(), kc.getXf());
			List list = cjService.getXsCjList1(kc.getKch());
			xsService.updateXf(kc.getXf() - xf, list);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addKcView
	 * @Description: 显示录入页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addKcView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addKc
	 * @Description: 执行录入操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addKc() throws Exception {
		Kcb k = new Kcb();
		String kch1 = kc.getKch();
		// 课程号已存在，不可重复录入
		if (kcService.find(kch1) != null)// 使用kcService业务逻辑接口中的find方法判断
		{
			return ERROR;
		}
		k.setKch(kch1);
		k.setKcm(kc.getKcm());
		k.setKxxq(kc.getKxxq());
		k.setXs(kc.getXs());
		k.setXf(kc.getXf());
		kcService.save(k);
		return SUCCESS;
	}
}
