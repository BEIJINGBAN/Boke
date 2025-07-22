package com.example.boke.User.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.boke.User.domain.User;

public interface IuserService {

    User getOne(QueryWrapper<User> queryWrapper);
}
