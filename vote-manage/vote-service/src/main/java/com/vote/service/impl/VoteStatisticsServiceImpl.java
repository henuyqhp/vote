package com.vote.service.impl;

import com.sun.tools.internal.jxc.ap.Const;
import com.vote.dao.VoteItemMapper;
import com.vote.dao.VoteMapper;
import com.vote.pojo.Vote;
import com.vote.pojo.VoteItem;
import com.vote.service.backend.VoteStatisticsService;
import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("voteStatisticsService")
public class VoteStatisticsServiceImpl implements VoteStatisticsService {
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private VoteItemMapper voteItemMapper;
    @Override
    public PageData getBollotJSON(Integer voteId) {
        PageData pageData = new PageData();
        Vote vote = voteMapper.selectByPrimaryKey(voteId);
        List<VoteItem> voteItemList = voteItemMapper.selectListByVoteId(voteId);
        if (vote != null && voteItemList != null){
            pageData.put("vote",vote);
            pageData.put("voteItemList",voteItemList);
            pageData.put("code", ResponseCode.成功.getCode());
        }else{
            pageData.put("code",ResponseCode.错误.getCode());
        }
        return pageData;
    }
}
