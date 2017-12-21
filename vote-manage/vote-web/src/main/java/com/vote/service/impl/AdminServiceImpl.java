package com.vote.service.impl;

import com.vote.dao.UserMapper;
import com.vote.dao.VoteMapper;
import com.vote.pojo.User;
import com.vote.pojo.Vote;
import com.vote.service.backend.AdminService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.enums.Enable;
import com.vote.util.enums.ResponseCode;
import com.vote.util.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VoteMapper voteMapper;
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
    public ResponseCode createVote(PageData pd) {
        PageData pageData = new PageData();
        Vote vote = new Vote();
        vote.setId(pd.getInt("voteId"));
        vote.setName(pd.getString("voteName"));
        vote.setDescription(pd.getString("voteDescription"));
        vote.setEcreator(pd.getInt("userId"));
        vote.setEnable(Enable.可用.getCode());
        int count = voteMapper.insert(vote);
        if (count>0){
            return ResponseCode.成功;
        }
        return ResponseCode.错误;

    }

    @Override
    public PageData newUser(PageData pd) {
        PageData pageData = new PageData();
        User user = new User();
        user.setId(pd.getInt("userId"));
        user.setUsername(pd.getString("userName"));
        user.setPassword(pd.getString("password"));
        user.setEnable(Enable.可用.getCode());
        user.setPhone();

        return null;
    }
}
