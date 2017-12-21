package com.vote.service.backend;

import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;

public interface VoteStatisticsService {
    PageData getBollotJSON(String name);

    ResponseCode doVote(PageData pageData);
}
