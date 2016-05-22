package com.djx.entity;

import java.awt.List;
import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

public class MyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Date date;
	private java.util.List cardNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public java.util.List getCardNum() {
		return cardNum;
	}

	public void setCardNum(java.util.List cardNum) {
		this.cardNum = cardNum;
	}

	@Override
	public String toString() {
		return name + ":" + cardNum.size();

	}
}
