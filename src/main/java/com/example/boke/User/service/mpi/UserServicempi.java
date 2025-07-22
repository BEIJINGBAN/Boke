package com.example.boke.User.service.mpi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.boke.User.domain.User;
import com.example.boke.User.service.IuserService;
import org.springframework.stereotype.Service;

/**
 * @author bjingban
 * @date 2025-07-14 21:37
 */
@Service
public class UserServicempi implements IuserService {

    @Override
    public User getOne(QueryWrapper<User> queryWrapper) {
        return queryWrapper.getEntity();
    }
}
