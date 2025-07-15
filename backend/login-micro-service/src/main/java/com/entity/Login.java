package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Login {
@Id
private String emailid;
private String password;
private String typeofuser;
@Transient
private String changePassword;
public String getChangePassword() {
	return changePassword;
}
public void setChangePassword(String changePassword) {
	this.changePassword = changePassword;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTypeofuser() {
	return typeofuser;
}
public void setTypeofuser(String typeofuser) {
	this.typeofuser = typeofuser;
}

}
