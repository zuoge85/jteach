package org.forkjoin.jteach.open;

import org.forkjoin.jteach.open.client.ApiManager;
import org.forkjoin.apikit.client.AbstractHttpClientAdapter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@Import({TestsContext.class})
@SpringBootTest(classes = OpenApiApplication.class)
//@ActiveProfiles("remote")
@ActiveProfiles("mock")
public abstract class BaseControllerTest {

    @Autowired
    protected ApiManager apiManager;

    @Autowired
    protected AbstractHttpClientAdapter httpClientAdapter;

//    public void auth() throws Exception {
//        AccessTokenModel accessTokenModel = apiManager.accountApi.tokenData(new TokenForm(ACCESS_KEY_ID, ACCESS_KEY_SECRET));
//        httpClientAdapter.setAccountToken(accessTokenModel.getAccessToken());
//    }
}