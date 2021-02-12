package com.altimetrik.resthateoas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.resthateoas.userinfo.Users;
import com.altimetrik.resthateoas.userinfo.UsersNameInfo;
import com.altimetrik.resthateoas.userinfo.UsersNameInfoDB;
import com.altimetrik.resthateoas.userinfo.UsersReport;
import com.altimetrik.resthateoas.userinfo.UsersReportDB;

@RestController
@RequestMapping("/rest/users")
public class UsersResourceController {


    @GetMapping("/all")
    public List<Users> getAll() {
        Users users1 = getUser();
    	//Users users1 = new Users("Pooja", 2000, 1);
        Users users2 = new Users("Priya", 1500, 2);
        Users users3 = new Users("Raj", 4000, 3);
        return Arrays.asList(users1, users2, users3);
    }

    private Users getUser() {
        Users users = new Users("Pooja", 2000, 1);
        Link link = ControllerLinkBuilder.linkTo(UsersResourceController.class)
                .slash(users.getUserid())
                .withSelfRel();
        users.add(link);
        return users;
    }

    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<Users> getHateOASAll() {
        Users users1 = new Users("Pooja", 2000, 1);
        Link link = ControllerLinkBuilder.linkTo(UsersResourceController.class)
                .slash(users1.getUserid()).withSelfRel();
        Link reportlink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UsersResourceController.class)
                .getReportByUserId(users1.getUserid()))
                .withRel("employee-report");
        users1.add(link, reportlink);
        Users users2 = new Users("Priya", 1500, 2);
        users2.add(ControllerLinkBuilder.linkTo(UsersResourceController.class)
                .slash(users2.getUserid()).withSelfRel());
        Users users3 = new Users("Raj", 4000, 3);
        users3.add(ControllerLinkBuilder.linkTo(UsersResourceController.class)
                .slash(users3.getUserid()).withSelfRel());
        return Arrays.asList(users1, users2, users3);
    }
    
    @RequestMapping(value = "/{userid}/report")
    public ResponseEntity<UsersReport> getReportByUserId (@PathVariable("userid") int userid)
    {
    	if (userid <= 3) {
    		UsersReport report = UsersReportDB.getUsersReportList().get(userid-1);
             
            //Self link
            Link selfLink = ControllerLinkBuilder
            		.linkTo(ControllerLinkBuilder.methodOn(UsersResourceController.class)
                    .getReportByUserId(report.getUserid()))
                    .withSelfRel();
             
            //Method link
            Link all = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UsersResourceController.class)
                    .getHateOASAll())
                    .withRel("Usersall");
             
                    report.add(selfLink);
                    report.add(all);
                return new ResponseEntity<UsersReport>(report, HttpStatus.OK);
        }
        return new ResponseEntity<UsersReport>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/{userid}")
    public ResponseEntity<UsersNameInfo> getUserNameInfo(@PathVariable("userid") int userid) {
    	if (userid <= 3) {
    		UsersNameInfo nameinfo = UsersNameInfoDB.getUsersNameList().get(userid-1);
    		
        Link link = ControllerLinkBuilder.linkTo(UsersResourceController.class)
                .slash(nameinfo.getUserid()).withSelfRel();
        Link Usersall = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UsersResourceController.class)
                .getHateOASAll())
                .withRel("Usersall");
        nameinfo.add(link, Usersall);
    	
        return new ResponseEntity<UsersNameInfo>(nameinfo, HttpStatus.OK);
    	}
    return new ResponseEntity<UsersNameInfo>(HttpStatus.NOT_FOUND);
    }


}
