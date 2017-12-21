package com.vote.service.backend;

import com.vote.util.PageData;
import com.vote.util.enums.ResponseCode;

public interface AdminService {
    PageData login(PageData pd);

    ResponseCode createVote(PageData pd);

    PageData newUser(PageData pd);
}
