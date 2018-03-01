package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.model.Xsb;
import org.model.Zyb;
import org.service.XsService;
import org.service.ZyService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: XsAction
 * @Description: 学生action类
 * @author litengbin
 * @date 2017年6月13日
 * 
 */
public class XsAction extends ActionSupport {
	private int pageNow = 1;
	private int pageSize = 8;
	private Xsb xs;
	private XsService xsService;
	private ZyService zyService;// 用于查找所有专业信息以加载专业下拉列表
	private File zpFile;// 用于获取照片文件
	private List list;// 存放专业集合
	private Zyb zyb;

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
	 * @Title: getXs
	 * @Description: xs的getter方法
	 * @param @return 参数
	 * @return Xsb 返回类型
	 * @throws
	 */
	public Xsb getXs() {
		return xs;
	}

	/**
	 * 
	 * @Title: setXs
	 * @Description: xs的setter方法
	 * @param @param xs 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setXs(Xsb xs) {
		this.xs = xs;
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
	 * @Title: getZyService
	 * @Description: zyService的getter方法
	 * @param @return 参数
	 * @return ZyService 返回类型
	 * @throws
	 */
	public ZyService getZyService() {
		return zyService;
	}

	/**
	 * 
	 * @Title: setZyService
	 * @Description: zyService的setter方法
	 * @param @param zyService 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setZyService(ZyService zyService) {
		this.zyService = zyService;
	}

	/**
	 * 
	 * @Title: getZpFile
	 * @Description: zpFile的getter方法
	 * @param @return 参数
	 * @return File 返回类型
	 * @throws
	 */
	public File getZpFile() {
		return zpFile;
	}

	/**
	 * 
	 * @Title: setZpFile
	 * @Description: zpFile的setter方法
	 * @param @param zpFile 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setZpFile(File zpFile) {
		this.zpFile = zpFile;
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: list的getter方法
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List getList() {
		return zyService.getAll();// 返回专业的集合
	}

	/**
	 * 
	 * @Title: setList
	 * @Description: list的setter方法
	 * @param @param list 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {// 显示所有学生信息
		// TODO Auto-generated method stub
		List list = xsService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findXs
	 * @Description: 用于从数据库中查找某个学生的详细信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String findXs() throws Exception {
		String xh = xs.getXh();
		Xsb stu = xsService.find(xh);// 直接使用XsService业务逻辑接口中的find方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getZyb
	 * @Description: zyb的getter方法
	 * @param @return 参数
	 * @return Zyb 返回类型
	 * @throws
	 */
	public Zyb getZyb() {
		return zyb;
	}

	/**
	 * 
	 * @Title: setZyb
	 * @Description: zyb的setter方法
	 * @param @param zyb 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}

	/**
	 * 
	 * @Title: getImage
	 * @Description: 获得学生照片
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String getImage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		String xh = xs.getXh();
		Xsb stu = xsService.find(xh);// 直接使用XsService业务逻辑接口中的find方法
		byte[] img = stu.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if (img != null && img.length != 0) {
			for (int i = 0; i < img.length; i++) {
				os.write(img[i]);
			}
			os.flush();
		}
		return NONE;
	}

	/**
	 * 
	 * @Title: deleteXs
	 * @Description: 删除学生信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteXs() throws Exception {
		String xh = xs.getXh();
		xsService.delete(xh);// 直接使用XsService业务逻辑接口中的delete方法
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateXsView
	 * @Description: 显示学生修改页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateXsView() throws Exception {
		String xh = xs.getXh();
		Xsb xsInfo = xsService.find(xh);// 直接使用XsService业务逻辑接口中的find()方法
		this.setZyb(xsInfo.getZyb());
		List zys = zyService.getAll();// 直接使用ZyService业务逻辑接口中的getAll()方法
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateXs
	 * @Description: 执行修改操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateXs() throws Exception {
		Xsb xs1 = xsService.find(xs.getXh());// 直接使用xsService业务逻辑接口的find()方法
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		// 直接使用ZyService业务逻辑接口的getOneZy()方法
		xs1.setZyb(zyService.getOneZy(zyb.getId()));
		xs1.setCssj(xs.getCssj());
		xs1.setBz(xs.getBz());
		if (this.getZpFile() != null) {
			FileInputStream fis = new FileInputStream(this.getZpFile());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			xs1.setZp(buffer);
		}
		Map request = (Map) ActionContext.getContext().get("request");
		xsService.update(xs1);// 直接使用XsService业务逻辑接口中的update()方法
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addXsView
	 * @Description: 显示录入页面
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addXsView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addXs
	 * @Description: 执行录入操作
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addXs() throws Exception {
		Xsb stu = new Xsb();
		String xh1 = xs.getXh();
		// 学号已存在，不可重复录入
		if (xsService.find(xh1) != null)// 使用XsService业务逻辑接口中的find方法判断
		{
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		// 直接使用ZyService业务逻辑接口中的getOneZy()方法
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if (this.getZpFile() != null) {
			FileInputStream fis = new FileInputStream(this.getZpFile());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		xsService.save(stu);
		return SUCCESS;
	}
}
