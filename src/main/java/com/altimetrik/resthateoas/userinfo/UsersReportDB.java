package com.altimetrik.resthateoas.userinfo;

import java.util.ArrayList;
import java.util.List;

public class UsersReportDB {
	 
    public static List<UsersReport> getUsersReportList()
    {
        List<UsersReport> list = new ArrayList<>();
        
        UsersReport users1 = new UsersReport(90, 91, 92, 1);
        UsersReport users2 = new UsersReport(80, 81, 82, 2);
        UsersReport users3 = new UsersReport(70, 71, 72, 3);
 
       
 
        list.add(users1);
        list.add(users2);
        list.add(users3);
 
        return list;
    }
}
