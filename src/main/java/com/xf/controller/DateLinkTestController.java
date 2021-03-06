package com.xf.controller;

import com.xf.domain.UserAccount;
import com.xf.service.DataLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DCJS
 * 2019/2/20.
 */
@Controller
@RequestMapping("dataLinkTest")
public class DateLinkTestController {
    @Autowired
    DataLinkService dataLinkService;

    @RequestMapping("datalink")
    @ResponseBody
    public UserAccount LinkTest() {
        UserAccount useraccount = dataLinkService.selectUserAccount(383180);
        useraccount.getPhone();
        return useraccount;
    }

}
