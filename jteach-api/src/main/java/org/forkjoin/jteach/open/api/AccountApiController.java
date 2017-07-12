package org.forkjoin.jteach.open.api;

import org.forkjoin.apikit.core.Account;
import org.forkjoin.apikit.core.Api;
import org.forkjoin.apikit.core.Result;
import org.forkjoin.jteach.open.db.entity.AccessTokenDO;
import org.forkjoin.jteach.open.form.LoginForm;
import org.forkjoin.jteach.open.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zuoge85 on 15/6/11.
 */
@Api
@RestController
@RequestMapping(value = "v1")
public class AccountApiController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @Account(false)
    public String login(@Valid LoginForm form) throws Exception {
        AccessTokenDO tokenDO = accountService.login(form.getName(), form.getPassword());
        return tokenDO.getToken();
    }

    @RequestMapping(value = "status", method = RequestMethod.GET)
    @Account(false)
    public Result<String> status() throws Exception {
        return Result.createSuccess("正常");
    }
}