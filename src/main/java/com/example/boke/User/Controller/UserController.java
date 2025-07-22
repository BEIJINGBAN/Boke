package com.example.boke.User.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.boke.User.domain.User;
import com.example.boke.User.service.IuserService;
import com.example.boke.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bjingban
 * @date 2025-07-14 21:05
 */
@RestController
public class UserController {

    @Autowired
    IuserService userService;

    @GetMapping("/userLogin")
    public String userLogin(@RequestParam("name") String name,@RequestParam("password")String password){

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();

        userQueryWrapper.eq("name", name).eq("password", password);
        User user = userService.getOne(userQueryWrapper);
        if(user == null){
            String res = TokenUtil.sign(name,password);
            System.out.println(res);
            return res;
        }
        return "失败";
    }
}
