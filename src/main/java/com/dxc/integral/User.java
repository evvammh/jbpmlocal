package com.dxc.integral;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class User implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.Double amount;
	private java.lang.String name;

	private java.lang.String emailid;

	public User() {
	}

	public java.lang.Double getAmount() {
		return this.amount;
	}

	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(java.lang.String emailid) {
		this.emailid = emailid;
	}

	public User(java.lang.Double amount, java.lang.String name,
			java.lang.String emailid) {
		this.amount = amount;
		this.name = name;
		this.emailid = emailid;
	}

}