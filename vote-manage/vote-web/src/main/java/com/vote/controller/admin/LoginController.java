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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

    private ResultSet resultSet = null;
    @RequestMapping(value = "login.do" , method = RequestMethod.POST)
    public String login(){
        PageData pd = this.getPageData();
        PageData pageData = null;
        try{
           pageData=adminService.login(pd);

            System.out.print(pageData.getInt(Const.CODE));
            if (pageData.getInt(Const.CODE) == ResponseCode.成功.getCode()){
                //User user = new User(pageData.get(Const.USER));
                //session.setAttribute(Const.USER,user);
                System.out.print("登录成功");
                return "user/index";
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "newUser.do",method = RequestMethod.POST)
    private Map<String,Object> newUser(){

        Map<String,Object> result = new HashMap<>();

        System.out.println("增加老师");
        PageData pd = this.getPageData();
        System.out.println(pd);
        PageData pageData =null;
        try {
            pageData = adminService.newUser(pd);
            result.putAll(pageData);
        } catch (Exception e) {
            logger.error(e.toString());
            result.put(Const.CODE, ResponseCode.异常.getCode());
        }

        return result;
    }

    @RequestMapping(value = "createVote.do",method = RequestMethod.POST)
    public Map<String,Object> vote(){

        Map<String,Object> result = new HashMap<>();
        User user = (User) session.getAttribute(Const.USER);
        PageData pd = this.getPageData();
        pd.put("userid",user);
        System.out.println(pd);
        try{
            ResponseCode pageData = adminService.createVote(pd);

        }catch (Exception e){
            logger.error(e.toString());
            result.put(Const.CODE,ResponseCode.异常.getCode());
        }
        return result;
    }



}
