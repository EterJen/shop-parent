package pers.eter.cache.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.eter.cache.config.RedisClient;
import pers.eter.cache.constant.Constant;
import pers.eter.core.exeception.ParamException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eter on 17-6-7.
 */
@Service
public class HotSearchKeyService {

    @Resource
    private RedisClient redisClient;

    public Long add(String keywords) {
        if (StringUtils.isBlank(keywords)) {
            throw new ParamException(101, "请输入热门关键字");
        }

        String[] kewardsArr = keywords.split(",");
        Long result = redisClient.setList(Constant.HOT_SEARCH_KEY, kewardsArr);

        return result;
    }

    public List<String> get() {
        List<String> result = redisClient.getList(Constant.HOT_SEARCH_KEY);
        return result;
    }
}
