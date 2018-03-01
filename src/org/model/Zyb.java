package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Zyb entity. @author MyEclipse Persistence Tools
 */

public class Zyb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String zym;
	private Integer rs;
	private String fdy;
	private Set xsbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Zyb() {
	}

	/** minimal constructor */
	public Zyb(Integer id, String zym) {
		this.id = id;
		this.zym = zym;
	}

	/** full constructor */
	public Zyb(Integer id, String zym, Integer rs, String fdy, Set xsbs) {
		this.id = id;
		this.zym = zym;
		this.rs = rs;
		this.fdy = fdy;
		this.xsbs = xsbs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZym() {
		return this.zym;
	}

	public void setZym(String zym) {
		this.zym = zym;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public String getFdy() {
		return this.fdy;
	}

	public void setFdy(String fdy) {
		this.fdy = fdy;
	}

	public Set getXsbs() {
		return this.xsbs;
	}

	public void setXsbs(Set xsbs) {
		this.xsbs = xsbs;
	}

}