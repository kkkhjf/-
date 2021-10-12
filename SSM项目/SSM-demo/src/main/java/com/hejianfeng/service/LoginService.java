package com.hejianfeng.service;

import com.hejianfeng.dao.LoginUserMapper;
import com.hejianfeng.pojo.Msg;
import com.hejianfeng.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HJF
 * @create 2021/10/8
 */
@Service
public class LoginService {

    @Autowired
    public LoginUserMapper loginUserMapper;

    public long checkUser(String userName){
        return loginUserMapper.countUser(userName);
    }

}
