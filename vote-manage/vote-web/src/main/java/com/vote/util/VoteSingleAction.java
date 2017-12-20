package com.vote.util;

import com.vote.pojo.Vote;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VoteSingleAction {

    private static VoteSingleAction voteSingleAction;
    private VoteSingleAction(){}
    public static VoteSingleAction getInstance(){
        if (voteSingleAction == null){
            synchronized (VoteSingleAction.class){
                if (voteSingleAction == null){
                    voteSingleAction  = new VoteSingleAction();
                }
            }
        }
        return voteSingleAction;
    }
    public static VoteSingleAction getCleanVoteSingleAction(){
        voteSingleAction = new VoteSingleAction();
        return voteSingleAction;
    }

//    public class MyMap extends Map {
//
//
//    }
}
