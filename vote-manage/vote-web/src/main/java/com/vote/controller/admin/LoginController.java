package com.vote.controller.admin;

import com.vote.controller.base.BaseController;
import com.vote.pojo.User;
import com.vote.service.backend.AdminService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;

@Controller
@RequestMapping("/admin/")
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

    private ResultSet resultSet = null;
    @RequestMapping(value = "login.do" , method = RequestMethod.POST)
    public String login(){
        PageData pd = this.getPageData();
        System.out.print(pd);
        try{
            PageData pageData =adminService.login(pd);
            if (pageData.getInt(Const.CODE) == ResponseCode.成功.getCode()){
                //User user = new User(pageData.get(Const.USER));
                //session.setAttribute(Const.USER,user);
                return "user/index";
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return "redirect:/";
    }
    @RequestMapping(value = "createVote.do",method = RequestMethod.POST)
    public String vote(){
        PageData pd = this.getPageData();
        System.out.println(pd);
        try{
            PageData pageData = adminService.createVote(pd);

        }catch (Exception e){

        }
        return null;
    }



}
