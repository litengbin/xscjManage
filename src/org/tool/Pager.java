package org.tool;

/**
 * 
 * @ClassName: Pager
 * @Description: 分页类
 * @author litengbin
 * @date 2017年5月12日
 * 
 */
public class Pager {
	private int pageNow;// 当前页数
	private int pageSize = 8;// 每页显示多少条记录
	private int totalPage;// 共有多少页
	private int totalSize;// 一共多少记录
	private boolean hasFirst;// 是否有首页
	private boolean hasPre;// 是否有前一页
	private boolean hasNext;// 是否有下一页
	private boolean hasLast;// 是否有最后一页

	/**
	 * 
	 * 创建一个新的实例 Pager.
	 * 
	 * @param pageNow
	 * @param totalSize
	 */
	public Pager(int pageNow, int totalSize) {
		// TODO Auto-generated constructor stub
		// 利用构造方法为变量赋值
		this.pageNow = pageNow;
		this.totalSize = totalSize;
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

	/**
	 * 
	 * @Title: getTotalPage
	 * @Description: totalPage的getter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getTotalPage() {
		// 一共多少页的算法
		totalPage = getTotalSize() / getPageSize();
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 
	 * @Title: setTotalPage
	 * @Description: totalPage的setter方法
	 * @param @param totalPage 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 
	 * @Title: getTotalSize
	 * @Description: totalSize的getter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * 
	 * @Title: setTotalSize
	 * @Description: totalSize的setter方法
	 * @param @param totalSize 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * @Title: isHasFirst
	 * @Description: hasFirst的getter方法
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isHasFirst() {
		// 如果当前为第1页就没有首页
		if (pageNow == 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasFirst
	 * @Description: hasFirst的setter方法
	 * @param @param hasFirst 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	/**
	 * 
	 * @Title: isHasPre
	 * @Description: hasPre的getter方法
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isHasPre() {
		// 如果有首页就有前一页，因为有首页就不是第1页
		if (pageNow == 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasPre
	 * @Description: hasPre的setter方法
	 * @param @param hasPre 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	/**
	 * 
	 * @Title: isHasNext
	 * @Description: hasNext的getter方法
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isHasNext() {
		// 如果有尾页就有下一页，因为有尾页表明不是最后一页
		if (isHasLast()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: setHasNext
	 * @Description: hasNext的setter方法
	 * @param @param hasNext 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * 
	 * @Title: isHasLast
	 * @Description: hasLast的getter方法
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isHasLast() {
		// 如果不是最后一页就有尾页
		if (pageNow == this.getTotalPage()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasLast
	 * @Description: hasLast的setter方法
	 * @param @param hasLast 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

}
