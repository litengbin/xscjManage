package org.model;

/**
 * Dlb entity. @author MyEclipse Persistence Tools
 */

public class Dlb implements java.io.Serializable {

	// Fields

	private Integer id;
	private Xsb xsb;
	private String kl;

	// Constructors

	/** default constructor */
	public Dlb() {
	}

	/** minimal constructor */
	public Dlb(Integer id, Xsb xsb) {
		this.id = id;
		this.xsb = xsb;
	}

	/** full constructor */
	public Dlb(Integer id, Xsb xsb, String kl) {
		this.id = id;
		this.xsb = xsb;
		this.kl = kl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Xsb getXsb() {
		return this.xsb;
	}

	public void setXsb(Xsb xsb) {
		this.xsb = xsb;
	}

	public String getKl() {
		return this.kl;
	}

	public void setKl(String kl) {
		this.kl = kl;
	}

}