package org.action;

import java.util.List;
import java.util.Map;

import org.model.Dlb;
import org.model.Xsb;
import org.service.DlService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: DlAction
 * @Description: 登陆action类
 * @author litengbin
 * @date 2017年6月13日
 * 
 */
public class DlAction extends ActionSupport {
	private Dlb dl;
	private DlService dlService;
	private XsService xsService;
	private int pageNow = 1;
	private int pageSize = 8;

	// 处理用户请求的execute方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean validated = false;// 验证成功标识
		Map session = ActionContext.getContext().getSession();// 获得会话对象,用来保存当前
		Dlb dl1 = null;
		// 先获得Dlb对象，如果是第一次访问该页，用户对象肯定为空，但如果是第二次甚至是第三次，就直接登陆主页而无需再次重复验证该用户信息
		dl1 = (Dlb) session.get("dl");
		// 如果用户是第一次进入，会话中尚未存储dl1持久化对象，故为null
		if (dl1 == null || dl1.getXsb().getXh() != dl.getXsb().getXh()) {
			dl1 = dlService.find(dl.getXsb().getXh(), dl.getKl());
			if (dl1 != null) {
				session.put("dl", dl1);// 把dl1对象存储在会话中
				validated = true;// 标识为true表示验证成功通过
			}
		} else {
			validated = true;// 该用户在之前已登录过并成功验证，故标识为true表示无需在验了
		}
		if (validated) {
			// 验证成功返回字符串"success"
			return SUCCESS;
		} else {
			// 验证失败返回字符串"error"
			return ERROR;
		}
	}

	public XsService getXsService() {
		return xsService;
	}

	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	/**
	 * 
	 * @Title: getDl
	 * @Description: dl的getter方法
	 * @param @return 参数
	 * @return Dlb 返回类型
	 * @throws
	 */
	public Dlb getDl() {
		return dl;
	}

	/**
	 * 
	 * @Title: setDl
	 * @Description: dl的setter方法
	 * @param @param dl 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setDl(Dlb dl) {
		this.dl = dl;
	}

	/**
	 * 
	 * @Title: getDlService
	 * @Description: dlService的getter方法
	 * @param @return 参数
	 * @return DlService 返回类型
	 * @throws
	 */
	public DlService getDlService() {
		return dlService;
	}

	/**
	 * 
	 * @Title: setDlService
	 * @Description: dlService的setter方法
	 * @param @param dlService 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setDlService(DlService dlService) {
		this.dlService = dlService;
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

	public String look() throws Exception {// 显示所有登录信息
		// TODO Auto-generated method stub
		List list = dlService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), dlService.findDlSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findDl
	 * @Description: 用于从数据库中查找某个登陆的详细信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String findDl() throws Exception {
		String xh = dl.getXsb().getXh();
		Dlb dl = dlService.find1(xh);// 直接使用dlService业务逻辑接口中的find1方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("dl", dl);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: deleteDl
	 * @Description: 删除登陆信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteDl() throws Exception {
		String xh = dl.getXsb().getXh();
		dlService.delete(xh);// 直接使用dlService业务逻辑接口中的delete方法
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateDlView
	 * @Description: 显示登陆修改页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateDlView() throws Exception {
		String xh = dl.getXsb().getXh();
		Dlb dlInfo = dlService.find1(xh);// 直接使用dlService业务逻辑接口中的find1()方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("dlInfo", dlInfo);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateDl
	 * @Description: 执行修改操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateDl() throws Exception {
		Dlb dl1 = dlService.find1(dl.getXsb().getXh());// 直接使用dlService业务逻辑接口的find1()方法
		dl1.setKl(dl.getKl());
		Map request = (Map) ActionContext.getContext().get("request");
		dlService.update(dl1);// 直接使用dlService业务逻辑接口中的update()方法
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addDlView
	 * @Description: 显示录入页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addDlView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addDl
	 * @Description: 执行录入操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addDl() throws Exception {
		Dlb d = new Dlb();
		String xh1 = dl.getXsb().getXh();
		// 学号已存在，不可重复录入
		if (dlService.find1(xh1) != null)// 使用dlService业务逻辑接口中的find1方法判断
		{
			return ERROR;
		}
		int size = dlService.findDlSize() + 1;
		d.setId(size);
		Xsb xs = xsService.find(xh1);
		d.setXsb(xs);
		d.setKl(dl.getKl());
		dlService.save(d);
		return SUCCESS;
	}
}
