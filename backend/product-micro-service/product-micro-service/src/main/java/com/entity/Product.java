package com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
@Id
private int pid;
private String pname;
private float price;
@Lob
private String imageurl;
private int qty;
@OneToMany
@JoinColumn(name = "pid")		// connect to FK in orders tables 
private List<Orders> listoforders;

public List<Orders> getListoforders() {
	return listoforders;
}
public void setListoforders(List<Orders> listoforders) {
	this.listoforders = listoforders;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}

}
