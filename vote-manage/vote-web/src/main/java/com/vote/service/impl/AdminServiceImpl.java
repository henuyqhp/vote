package com.vote.service.impl;

import com.vote.dao.UserMapper;
import com.vote.pojo.User;
import com.vote.service.backend.AdminService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;
import com.vote.util.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageData login(PageData pd) {
        PageData pageData = new PageData();
        int count = userMapper.checkUserId(pd);
        if (count == 0){
            pageData.put(Const.CODE, ResponseCode.错误.getCode());
            pageData.put(Const.MSG,"帐号错误");
            return pageData;
        }
        User user = userMapper.selectLogin(pd);
        if (user == null){
            pageData.put(Const.CODE, ResponseCode.错误.getCode());
            pageData.put(Const.MSG,"密码错误");
            return pageData;
        }
        pageData.put(Const.USERTYPE, UserType.管理员.getCode());
        pageData.put(Const.USER,user);
        pageData.put(Const.CODE,ResponseCode.成功.getCode());
        return pageData;
    }

    @Override
    public PageData createVote(PageData pd) {
        return null;
    }
}
