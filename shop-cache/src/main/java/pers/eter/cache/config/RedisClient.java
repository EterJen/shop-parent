package pers.eter.cache.config;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eter on 17-6-6.
 */
@Component
public class RedisClient {
    @Resource(name = "master.jedis")
    private Jedis masterJedis;
    @Resource(name = "slave.jedis")
    private Jedis slaveJedis;

    public void sete(String key, String value) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            return;
        }

        masterJedis.set(key, value);
    }

    public String get(String key) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String value = slaveJedis.get(key);
        return value;
    }

    public Long setList(String key, String...values) {
        if (StringUtils.isBlank(key) || null == values || values.length < 1) {
            return 0L;
        }
        return masterJedis.lpush(key,values);
    }

    public List<String> getList(String key) {
        if (StringUtils.isBlank(key)) {
            return Collections.emptyList();
        }
        List<String> values = slaveJedis.lrange(key, 0, -1);
        return values;
    }
}
