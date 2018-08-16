package com.leren.shiro;

import com.leren.CacheConstants;
import com.util.RedisUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lee
 * @Date:26/03/2018
 */

public class RetryLimitMatcher extends HashedCredentialsMatcher {


    /**
     * 密码可试最大次数
     */
    private static final int MAX_TRY_TIMES = 5;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        String username = (String) token.getPrincipal();
        //retry count + 1
        Object times = redisUtil.getCacheObject(CacheConstants.userRetry(username));
        if (times == null) {
            times = new AtomicInteger(0);
            redisUtil.setCacheObject(CacheConstants.userRetry(username), times);
        }

        AtomicInteger retryCount = (AtomicInteger) times;

        if (retryCount.get() >= MAX_TRY_TIMES) {
            throw new ExcessiveAttemptsException();
        }

        if (retryCount.incrementAndGet() == MAX_TRY_TIMES) {

            redisUtil.setCacheObject(CacheConstants.userRetry(username), retryCount, 10, TimeUnit.MINUTES);

            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);

        if (matches) {
            redisUtil.delete(CacheConstants.userRetry(username));
        } else {
            redisUtil.delete(CacheConstants.user(username));

            redisUtil.setCacheObject(CacheConstants.userRetry(username), retryCount);
        }
        return matches;
    }

}
