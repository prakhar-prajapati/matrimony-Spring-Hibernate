package bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_details")
public class userBean {
String name,gender,religion,mother_tongue,caste,country,password;
long mobile;
@Id
String email;
Date dob;
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public String getMother_tongue() {
	return mother_tongue;
}
public void setMother_tongue(String mother_tongue) {
	this.mother_tongue = mother_tongue;
}
public String getCaste() {
	return caste;
}
public void setCaste(String caste) {
	this.caste = caste;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}


}
