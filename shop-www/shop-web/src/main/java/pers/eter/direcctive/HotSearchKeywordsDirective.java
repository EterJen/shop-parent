package pers.eter.direcctive;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pers.eter.constant.UrlConstant;
import pers.eter.core.base.ResultInfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Eter on 17-6-8.
 */
@Component
public class HotSearchKeywordsDirective extends BaseDirective {
    @Value("${cache.service.domain}")
    private String cacheServiceDomain;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        /*获取数据*/
        RestTemplate restTemplate = new RestTemplate();
        ResultInfo resultInfo = restTemplate.getForObject(cacheServiceDomain + UrlConstant.HOT_SEARCH_KEYWORDS_URL, ResultInfo.class);
        List<String> kewords = (List<String>) resultInfo.getResult();


        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel result = beansWrapper.wrap(kewords);

        setVariable(env, body, "keywords", result);
    }
}
