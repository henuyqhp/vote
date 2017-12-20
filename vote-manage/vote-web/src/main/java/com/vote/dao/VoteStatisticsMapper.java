package com.vote.dao;

import com.vote.pojo.Vote;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface VoteStatisticsMapper {

    @Select("select * from vote where name = #{name} and enable = 1")
    @ResultType(Vote.class)
    Vote selectVoteBy(String name);


}
