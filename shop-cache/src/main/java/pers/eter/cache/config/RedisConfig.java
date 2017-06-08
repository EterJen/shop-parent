package pers.eter.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Eter on 17-6-6.
 */
@Configuration
public class RedisConfig {

    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.maxWaitMills}")
    private Integer maxWaitMills;
    @Value("${redis.timeout}")
    private Integer timeout;

    @Value("${redis.masterHost}")
    private String masterHost;
    @Value("${redis.masterPort}")
    private Integer masterPort;
    @Value("${redis.masterPassword}")
    private String masterPassword;

    @Value("${redis.slaveHost}")
    private String slaveHost;
    @Value("${redis.slavePort}")
    private Integer slavePort;
    @Value("${redis.slavePassword}")
    private String slavePassword;


    @Bean(name = "master.jedis")
    public Jedis getMaseterJedisInstance() {
        JedisPoolConfig jedisPoolConfig = initJedisPoolCOnfig();

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, masterHost, masterPort, timeout, masterPassword);

        return jedisPool.getResource();
    }

    @Bean(name = "slave.jedis")
    public Jedis getSlaveJedisInstance() {
        JedisPoolConfig jedisPoolConfig = initJedisPoolCOnfig();

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, slaveHost, slavePort, timeout, slavePassword);

        return jedisPool.getResource();
    }

    private JedisPoolConfig initJedisPoolCOnfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMills);

        return jedisPoolConfig;
    }
}
