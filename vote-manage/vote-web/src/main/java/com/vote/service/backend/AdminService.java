package com.vote.service.backend;

import com.vote.util.PageData;

public interface AdminService {
    PageData login(PageData pd);

    PageData createVote(PageData pd);
}
