package pers.eter.cache.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.eter.cache.service.HotSearchKeyService;
import pers.eter.core.base.BaseController;
import pers.eter.core.base.ResultInfo;
import pers.eter.core.exeception.ParamException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eter on 17-6-7.
 */
@RestController
@RequestMapping("hot_search")
public class HotSearchKeyController extends BaseController {
    @Resource
    private HotSearchKeyService hotSearchKeyService;

    @RequestMapping("add")
    public ResultInfo add(String keywords) {
        try {
            Long resultCount = hotSearchKeyService.add(keywords);
            return success(resultCount);
        } catch (ParamException e) {
            int code = e.getResultCode();
            String message = e.getMessage();

            return failure(code, message);
        }
    }

    @RequestMapping("get")
    public ResultInfo get() {
        List<String> result = hotSearchKeyService.get();
        return success(result);
    }
}
