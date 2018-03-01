package org.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */

public class Xsb implements java.io.Serializable {

	// Fields

	private String xh;
	private Zyb zyb;
	private String xm;
	private Short xb;
	private Date cssj;
	private Integer zxf;
	private String bz;
	private byte[] zp;
	private Set cjbs = new HashSet(0);
	private Set dlbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Xsb() {
	}

	/** minimal constructor */
	public Xsb(String xh, Zyb zyb, String xm, Short xb) {
		this.xh = xh;
		this.zyb = zyb;
		this.xm = xm;
		this.xb = xb;
	}

	/** full constructor */
	public Xsb(String xh, Zyb zyb, String xm, Short xb, Date cssj, Integer zxf,
			String bz, byte[] zp, Set cjbs, Set dlbs) {
		this.xh = xh;
		this.zyb = zyb;
		this.xm = xm;
		this.xb = xb;
		this.cssj = cssj;
		this.zxf = zxf;
		this.bz = bz;
		this.zp = zp;
		this.cjbs = cjbs;
		this.dlbs = dlbs;
	}

	// Property accessors

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public Zyb getZyb() {
		return this.zyb;
	}

	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Short getXb() {
		return this.xb;
	}

	public void setXb(Short xb) {
		this.xb = xb;
	}

	public Date getCssj() {
		return this.cssj;
	}

	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}

	public Integer getZxf() {
		return this.zxf;
	}

	public void setZxf(Integer zxf) {
		this.zxf = zxf;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public byte[] getZp() {
		return this.zp;
	}

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

	public Set getCjbs() {
		return this.cjbs;
	}

	public void setCjbs(Set cjbs) {
		this.cjbs = cjbs;
	}

	public Set getDlbs() {
		return this.dlbs;
	}

	public void setDlbs(Set dlbs) {
		this.dlbs = dlbs;
	}

}