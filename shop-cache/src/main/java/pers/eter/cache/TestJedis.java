package pers.eter.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.sound.midi.Soundbank;

/**
 * Created by Eter on 17-6-6.
 */
public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.2.118", 6379);
        jedis.auth("tiger");
        jedis.set("abc", "hhh");
        String rest = jedis.get("abc");
        System.out.println(rest);
    }

    public static void testPoll() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxWaitMillis(1000);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.2.118", 6379, 1000, "tiger");

        Jedis jedis = jedisPool.getResource();
        jedis.set("lqc", "xxx");
        String value = jedis.get("lqx");
        System.out.println(value);

    }
}
