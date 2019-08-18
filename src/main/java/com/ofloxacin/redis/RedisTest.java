package com.ofloxacin.redis;

import redis.clients.jedis.Jedis;

/**
 * @author chens
 * @date 2018/11/27 17:22
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("yourpassword");
        jedis.set("fjedis", "nihao");
    }
}
