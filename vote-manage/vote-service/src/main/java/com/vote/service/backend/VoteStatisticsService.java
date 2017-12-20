package com.vote.service.backend;

import com.vote.util.PageData;

public interface VoteStatisticsService {
    PageData getBollotJSON(Integer voteId);
}
