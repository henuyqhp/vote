package com.vote.service;


import com.vote.dao.LogVoteMapper;
import com.vote.pojo.LogVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("a")
public class A {

    @Autowired
    private LogVoteMapper logVoteMapper;
    public LogVote a(){
        LogVote ll = logVoteMapper.selectByPrimaryKey(1);
        System.out.println(ll);
        return ll;
    }
}
