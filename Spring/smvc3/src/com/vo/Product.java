package com.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Product {	
	private int id;
	private String name;
	private double price;
	private Date regdate;
	private String imgname;
	MultipartFile mf;
	
	
	public Product() {
	}
	
	public Product(String name, double price, String imgname) {
		this.name = name;
		this.price = price;
		this.imgname = imgname;
	}

	public Product(int id, String name, double price, String imgname) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
	}
	public Product(int id, String name, double price, Date regdate, String imgname) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
		this.imgname = imgname;
	}
	
	
	
	
	public Product(int id, String name, double price, Date regdate, String imgname, MultipartFile mf) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
		this.imgname = imgname;
		this.mf = mf;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdata(Date regdate) {
		this.regdate = regdate;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
	public MultipartFile getMf() {
		return mf;
	}

	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + ", imgname="
				+ imgname + ", mf=" + mf + "]";
	}

	
	
}
