package org.forkjoin.jteach.open.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.forkjoin.apikit.spring.I18nValidationException;
import org.forkjoin.jteach.core.utils.UUIDUtils;
import org.forkjoin.jteach.open.OpenApiAccount;
import org.forkjoin.jteach.open.cache.AccessTokenCache;
import org.forkjoin.jteach.open.cache.UserCache;
import org.forkjoin.jteach.open.db.entity.AccessTokenDO;
import org.forkjoin.jteach.open.db.entity.UserDO;
import org.forkjoin.jteach.open.db.entity.meta.AccessTokenMeta;
import org.forkjoin.jteach.open.db.entity.meta.UserMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Service
public class AccountService {
    public static final int TOKEN_LENGTH = 64;
    public static final int SIZE = 2000;


    @Autowired
    private AccessTokenCache accessTokenCache;

    @Autowired
    private UserCache userCache;

    /**
     * 密码盐
     */
    @Value("${account.passwordSalt}")
    private String passwordSalt;

    private Cache<String, OpenApiAccount> accountCache;

    @PostConstruct
    public void init() {
        accountCache = CacheBuilder.newBuilder()
                .weakKeys()
                .weakValues()
                .maximumSize(SIZE)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
    }

    public AccessTokenDO login(String name, String password) {

        UserDO user = userCache.getByUnique(UserMeta.UNIQUE_NAME, name);

        if (user == null) {
            throw I18nValidationException.of("user", "noFound", "user");
        }
        if (!StringUtils.equals(user.getPassword(), newHashPassword(password))) {
            throw I18nValidationException.of("password", "error", "password");
        }

        AccessTokenDO tokenDO = new AccessTokenDO();
        tokenDO.setUserId(user.getId());
        tokenDO.setToken(password);
        tokenDO.setCreateTime(new Date());
        accessTokenCache.insert(tokenDO);
        return tokenDO;
    }


    private String newAccessToken() {
        String uuid = UUIDUtils.randomUUIDToBase64() + UUIDUtils.randomUUIDToBase64();
        return uuid + RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH - uuid.length());
    }

    /**
     * 2次hash，可以吧第一次hash放到客户端
     */
    private String newHashPassword(String password) {
        return newHashPassword(passwordSalt, password);
    }

    private static String newHashPassword(String passwordSalt,String password) {
        password = DigestUtils.sha256Hex(password);
        return Base64Utils.encodeToUrlSafeString(DigestUtils.sha256(password + passwordSalt));
    }

    public OpenApiAccount getByToken(String accessToken) throws ExecutionException {
        if (accessToken == null) {
            return null;
        }
        OpenApiAccount openApiAccount = accountCache.get(accessToken, () -> {
            AccessTokenDO tokenDO = accessTokenCache.getByUnique(AccessTokenMeta.UNIQUE_TOKEN, accessToken);

            if (tokenDO == null) {
                throw I18nValidationException.of("accessToken", "noFound", "accessToken");
            }

            UserDO userDO = userCache.get(new UserDO.Key(tokenDO.getId()));
            if (userDO == null) {
                throw I18nValidationException.of("user", "noFound", "user");
            }
            return new OpenApiAccount(userDO);
        });
        return openApiAccount;
    }

    public static void main(String[] args) {
        System.out.println(newHashPassword("keCT13", "111111"));
    }
}
