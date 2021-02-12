package com.altimetrik.resthateoas.userinfo;

import org.springframework.hateoas.ResourceSupport;

public class Users extends ResourceSupport{
	 	private String name;
	    private Integer salary;
	    private Integer userid;

	    public Users(String name, Integer salary, Integer userid) {
	        this.name = name;
	        this.salary = salary;
	        this.userid = userid;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getSalary() {
	        return salary;
	    }

	    public void setSalary(Integer salary) {
	        this.salary = salary;
	    }

		public Integer getUserid() {
			return userid;
		}

		public void setUserid(Integer userid) {
			this.userid = userid;
		}

		
	    

}
