package com.xf.service;

import com.xf.domain.UserAccount;
import com.xf.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DCJS
 * 2019/2/20.
 */
@Service
public class DataLinkService {
    @Autowired
    UserAccountMapper userAccountMapper;

    public UserAccount selectUserAccount(Integer userId){
        UserAccount userAccount = userAccountMapper.selectByUserId(userId);
        return userAccount;
    }
}
