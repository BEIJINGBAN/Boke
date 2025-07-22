package com.example.boke.User.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author bjingban
 * @date 2025-07-14 16:01
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String name;

    private String password;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String del_flag;


}
