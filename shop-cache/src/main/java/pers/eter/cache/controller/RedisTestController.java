package pers.eter.cache.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.eter.cache.service.RedistTestService;
import pers.eter.core.base.ResultInfo;

/**
 * Created by Eter on 17-6-6.
 */
@RequestMapping("redis")
@RestController
public class RedisTestController {
    @Autowired
    private RedistTestService redistTestService;

    @RequestMapping("set")
    public ResultInfo set(String key,@RequestParam(name = "value") String value) {
        redistTestService.set(key, value);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult("success");
        resultInfo.setResultCode(200);
        resultInfo.setResultMessage("Success");

        return resultInfo;
    }

    @RequestMapping("get")
    public ResultInfo get(String key) {
        String value = redistTestService.get(key);
        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setResult(value);
        resultInfo.setResultCode(200);
        resultInfo.setResultMessage("Success");

        return resultInfo;
    }
}
