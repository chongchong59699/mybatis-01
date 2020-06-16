package com.qf.service;

import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo getPageInfo(Integer pageNum, Integer pageSize);
}
