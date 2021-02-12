package com.altimetrik.resthateoas.userinfo;

import org.springframework.hateoas.RepresentationModel;

public class UsersReport extends RepresentationModel
{
	private Integer phy;
    private Integer chem;
    private Integer maths;
    private Integer userid;
	public Integer getPhy() {
		return phy;
	}
	public void setPhy(Integer phy) {
		this.phy = phy;
	}
	public Integer getChem() {
		return chem;
	}
	public void setChem(Integer chem) {
		this.chem = chem;
	}
	public Integer getMaths() {
		return maths;
	}
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public UsersReport(Integer phy, Integer chem, Integer maths, Integer id) {
		super();
		this.userid = id;
		this.phy = phy;
		this.chem = chem;
		this.maths = maths;
	}
	
   
}