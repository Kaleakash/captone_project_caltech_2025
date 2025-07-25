package com.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int oid;
private int pid;			// FK
private LocalDateTime odateandtime;		// system date and time. 
private int qty;
private float totalprice;

public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public float getTotalprice() {
	return totalprice;
}
public void setTotalprice(float totalprice) {
	this.totalprice = totalprice;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public LocalDateTime getOdateandtime() {
	return odateandtime;
}
public void setOdateandtime(LocalDateTime odateandtime) {
	this.odateandtime = odateandtime;
}


}
