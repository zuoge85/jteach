package org.forkjoin.jteach.open.api;

import org.forkjoin.jteach.open.BaseControllerTest;
import org.forkjoin.jteach.open.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zuoge85@gmail.com on 2017/6/6.
 */
public class AccountApiControllerTest extends BaseControllerTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void token() throws Exception {
//        Result<AccessTokenModel> result = apiManager.accountApi.token(new TokenForm(ACCESS_KEY_ID, ACCESS_KEY_SECRET + "s"));
//        Assert.assertEquals(result.getStatus(), Result.VALIDATOR);
//        Assert.assertNotNull(result.getMsgMap().get("accessKeySecret"));
//
//        AccessTokenModel accessTokenModel = apiManager.accountApi.tokenData(new TokenForm(ACCESS_KEY_ID, ACCESS_KEY_SECRET));
//
//        Assert.assertEquals(accessTokenModel.getExpiresSecond(), accountService.getTokenTimeOutSecond());
//        Assert.assertNotNull(accessTokenModel.getAccessToken());
    }
}
