package com.altimetrik.resthateoas.userinfo;

import org.springframework.hateoas.ResourceSupport;

public class UsersNameInfo extends ResourceSupport{
	 	private String firstName;
	    private String middleName;
	    private String lastName;
	    private Integer userid;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
		public UsersNameInfo(String firstName, String middleName, String lastName, Integer userid) {
			super();
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.userid = userid;
		}
		
	   
}
