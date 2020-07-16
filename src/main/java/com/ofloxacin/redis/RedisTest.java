package com.ofloxacin.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author chens
 * @date 2018/11/27 17:22
 */
public class RedisTest {

    private static Jedis jedis;

    static {
        jedis = new Jedis("localhost", 6379);
        jedis.auth("123456");
    }

    public static void main(String[] args) {
        System.out.println(jedis.get("key1"));
        System.out.println(lock("mylock", Thread.currentThread().getName(), 60000));
        System.out.println(release("mylock", Thread.currentThread().getName()));
        jedis.bgsave();
    }

    private static boolean lock(String key, String requestId, int expireTime) {
        String result = jedis.set(key, requestId, "NX", "PX", expireTime);
        return "OK".equals(result);
    }

    private static boolean release(String key, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(requestId));
        return Long.valueOf(1L).equals(result);
    }
}
