package com.wzbc.video.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class TokenUtil {
    @Autowired
    private RedisUtil redisUtil;

    final static String TOKEN_KEYPREFIX = "ysw";

    final static Long TOKEN_TIME = 86400L;

    /**
     * 生成令牌
     *
     * @param redisValue redis存放的值
     * @return 返回token
     */
    public String createToken(String redisValue) {
        return createToken(redisValue, null);
    }

    /**
     * 生成令牌
     *
     * @param redisValue redis存放的值
     * @param time       有效期
     * @return 返回token
     */
    public String createToken(String redisValue, Long time) {
        if (StringUtils.hasLength(redisValue)) {
            new Exception("redisValue Not nul");
        }
        if (time==null) {
            time=TOKEN_TIME;
        }
        String token = TOKEN_KEYPREFIX + UUID.randomUUID().toString().replace("-", "");
        redisUtil.setString(token, redisValue, time);
        return token;
    }

    /**
     * 根据token获取redis中的value值
     *
     * @param token
     * @return
     */
    public String getToken(String token) {
        if (token.isEmpty()) {
            return null;
        }
        String value = redisUtil.getString(token);
        return value;
    }

    /**
     * 移除token
     *
     * @param token
     * @return
     */
    public Boolean removeToken(String token) {
        if (token.isEmpty()) {
            return null;
        }
        return redisUtil.delKey(token);

    }
}
