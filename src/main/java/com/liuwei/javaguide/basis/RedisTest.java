package com.liuwei.javaguide.basis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/4/16 15:55
 */
public class RedisTest {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis_m = new Jedis("192.168.10.102", 6379);
        Jedis jedis_s = new Jedis("192.168.10.102", 6380);

        jedis_m.watch("k1");
        String k1 = jedis_s.get("k1");
        if (Integer.valueOf(k1) < 150) {
            jedis_m.unwatch();
            jedis_m.incrBy("k1", 200);
            return;
        } else {
            Transaction multi = jedis_m.multi();
            multi.decrBy("k1", 50);
            multi.incrBy("k2", 50);
            multi.exec();
        }
    }
}
