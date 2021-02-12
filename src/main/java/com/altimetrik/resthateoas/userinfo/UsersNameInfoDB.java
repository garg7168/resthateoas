package com.altimetrik.resthateoas.userinfo;

import java.util.ArrayList;
import java.util.List;

public class UsersNameInfoDB {
	 
    public static List<UsersNameInfo> getUsersNameList()
    {
        List<UsersNameInfo> list = new ArrayList<>();
        
        UsersNameInfo name1 = new UsersNameInfo("Pooja","Kumari","Agarwal", 1);
        UsersNameInfo name2 = new UsersNameInfo("Priya","Kumari","Singh", 2);
        UsersNameInfo name3 = new UsersNameInfo("Raj","Kumar","Gupta", 3);
 
       
 
        list.add(name1);
        list.add(name2);
        list.add(name3);
 
        return list;
    }
}
