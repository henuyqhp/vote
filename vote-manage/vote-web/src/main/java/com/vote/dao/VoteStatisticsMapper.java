package com.vote.dao;

import com.vote.pojo.Vote;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VoteStatisticsMapper {

    @Select("select * from vote where name = #{name} and enable = 1")
    @ResultType(Vote.class)
    Vote selectVoteBy(String name);

    @Update({"update vote_item set ballot = ballot +1,modifyTime = now() where id = #{id}"})
    @ResultType(int.class)
    int upDateBoallot(int id);
}
