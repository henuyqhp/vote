package com.vote.controller;


import com.vote.service.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
public class AA {

    @Autowired
    private A a;

    @RequestMapping("get.do")
    @ResponseBody
    public Map<String,Object> get(){
        Map<String,Object> result = new HashMap<>();
        a.a();
        result.put("dd",1232);
        return result;
    }

//    @RequestMapping({"/{lib}/{page}"})
//    public String show(@PathVariable String lib,@PathVariable String page)
//    {
//        System.out.println(page);
//        return lib + "/" + page;
//    }
//    @RequestMapping({"{page}"})
//    public String showOne(@PathVariable String page)
//    {
//        System.out.println(page);
//        return page;
//    }
}
